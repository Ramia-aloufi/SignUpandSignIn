package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    lateinit var signout: Button
    lateinit var data:TextView
    lateinit var mobile:TextView
    lateinit var db:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        signout = findViewById(R.id.SignOut)
        data = findViewById(R.id.textView3)
        mobile = findViewById(R.id.textView)
        var db = DBHelper(this)
        var rr = intent.getStringExtra("mobile")


        mobile.text = "WELCOME\n $rr"

        var nn = db.retriveDatawith(rr!!)
        data.text = nn



        signout.setOnClickListener { val intint = Intent(this,MainActivity::class.java)
        startActivity(intint)}
    }
}