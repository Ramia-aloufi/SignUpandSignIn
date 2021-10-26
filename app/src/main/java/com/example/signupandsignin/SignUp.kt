package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var mob:EditText
    lateinit var loc:EditText
    lateinit var pw:EditText
    lateinit var submit:Button
lateinit var db:DBHelper
    var namt = ""
    var mobt = ""
    var loct = ""
    var pwt = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_main3)
        title = "SignUp"
        name = findViewById(R.id.editTextTextPersonName)
        mob = findViewById(R.id.editTextTextPersonName2)
        loc = findViewById(R.id.editTextTextPersonName3)
        pw = findViewById(R.id.editTextTextPersonName4)
        submit = findViewById(R.id.submit)
        db = DBHelper(this)

        submit.setOnClickListener {submit() }

    }

    fun submit(){
        namt = name.text.toString()
        mobt = mob.text.toString()
        loct = loc.text.toString()
        pwt = pw.text.toString()

        var status = db.saveddata(namt,mobt,loct,pwt)
        Toast.makeText(this,"Saved $status",Toast.LENGTH_SHORT).show()
        name.text.clear()
        mob.text.clear()
        loc.text.clear()
        pw.text.clear()
        name.isFocused

        val intent = Intent(this,MainActivity4::class.java)
            .putExtra("mobile","$mobt")

        startActivity(intent)
    }
}