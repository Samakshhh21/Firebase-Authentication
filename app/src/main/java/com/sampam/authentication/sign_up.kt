package com.sampam.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.sampam.authentication.databinding.ActivitySignUpBinding

lateinit var binding1: ActivitySignUpBinding
class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1=DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        val auth=FirebaseAuth.getInstance()

        binding1.button.setOnClickListener{
            val ed1= binding1.e1.text.toString()
            val ed2= binding1.e2.text.toString()
            val ed3= binding1.e3.text.toString()
            if(ed1.isEmpty() || ed2.isEmpty() || ed3.isEmpty()){
                Toast.makeText(this,"Credentials cannot be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(ed2 !=ed3){
                Toast.makeText(this,"Password do not match",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(ed2.length<6){
                Toast.makeText(this,"Password should have minimum 6 characters",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(ed1,ed2)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"Sign Up Complited Succesfully",Toast.LENGTH_SHORT).show()
                        auth.currentUser?.sendEmailVerification()

                    }
                    else Toast.makeText(this,"${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
        }
    }
}