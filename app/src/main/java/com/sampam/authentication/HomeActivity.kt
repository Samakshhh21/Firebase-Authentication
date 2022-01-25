package com.sampam.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.sampam.authentication.databinding.ActivityHomeBinding

lateinit var binding3: ActivityHomeBinding
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3=DataBindingUtil.setContentView(this,R.layout.activity_home)
        val auth=FirebaseAuth.getInstance()
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding3.button3.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}

