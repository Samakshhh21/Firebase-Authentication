package com.sampam.authentication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.sampam.authentication.databinding.ActivityListBinding

lateinit var binding4:ActivityListBinding
class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding4=DataBindingUtil.setContentView(this,R.layout.activity_list)
        val mylist= mutableListOf<datalist>()
        val adap=databaseAdapter(mylist)
        binding4.rv.adapter=adap
        binding4.rv.layoutManager=LinearLayoutManager(this)
        val mydatabase=FirebaseDatabase.getInstance()
        val auth=FirebaseAuth.getInstance()
        mydatabase.reference.child(auth.currentUser?.uid!!).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                mylist.clear()
                for(i in snapshot.children){
                    mylist.add(datalist(i.key.toString(),i.value.toString()))
                }
                adap.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                println(error.toString())
            }

        })

    }
}