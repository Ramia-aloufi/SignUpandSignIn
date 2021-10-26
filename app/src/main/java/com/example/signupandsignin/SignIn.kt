package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var pw:EditText
    lateinit var signin:Button
lateinit var db:DBHelper
    var nametext = ""
    var passwordtext = ""
    var check = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_main2)
        name = findViewById(R.id.editTextTextPersonName5)
        pw = findViewById(R.id.editTextTextPassword)
        signin = findViewById(R.id.button3)
        title = "SignIn"
        db = DBHelper(this)



        signin.setOnClickListener {
            nametext = name.text.toString()
            passwordtext = pw.text.toString()
            check = db.retrivePasswith(nametext)

            if (passwordtext.equals(check)){
                var mob = db.retriveMobwith(nametext)
                Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT).show();
                val intent = Intent(this,MainActivity4::class.java)
                    .putExtra("mobile","$mob")
                startActivity(intent)

            }else{
                Toast.makeText(this,"No data match,SignUp!",Toast.LENGTH_SHORT).show()
            }

        }


    }
}