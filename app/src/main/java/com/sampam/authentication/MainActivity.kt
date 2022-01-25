package com.sampam.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.sampam.authentication.databinding.ActivityMainBinding

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val auth=FirebaseAuth.getInstance()
        if(auth.currentUser!=null){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
        binding.button4.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
            finish()
        }
        binding.button5.setOnClickListener{
            startActivity(Intent(this,sign_up::class.java))
        }
    }
}