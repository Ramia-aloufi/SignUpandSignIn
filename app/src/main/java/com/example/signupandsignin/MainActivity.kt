package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var signIn:Button
    lateinit var signUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_main)
        signIn = findViewById(R.id.button)
        signUp = findViewById(R.id.button2)

        signIn.setOnClickListener { go(SignIn::class.java) }
        signUp.setOnClickListener { go(SignUp::class.java) }
    }

    fun go(T:Class<*>){
        val intent = Intent(this,T)
        startActivity(intent)
    }
}