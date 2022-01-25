package com.sampam.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.sampam.authentication.databinding.ActivityLoginBinding

lateinit var bindin2:ActivityLoginBinding
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindin2=DataBindingUtil.setContentView(this,R.layout.activity_login)

        val auth=FirebaseAuth.getInstance()
        bindin2.button2.setOnClickListener{
            val edl1= bindin2.el1.text.toString()
            val edl2= bindin2.el2.text.toString()
            if(edl1.isEmpty() || edl2.isEmpty()){
                Toast.makeText(this,"Credentials cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            bindin2.progressBar.isVisible=true
            auth.signInWithEmailAndPassword(edl1,edl2)
                .addOnCompleteListener {
                    bindin2.progressBar.isVisible=false
                    if(it.isSuccessful){
                        startActivity(Intent(this,HomeActivity::class.java))
                    }
                    else {
                        Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}