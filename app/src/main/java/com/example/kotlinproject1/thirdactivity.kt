package com.example.kotlinproject1
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class thirdactivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_third)
        val bob = findViewById<Button>(R.id.button3)
        bob.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View){
                val name = findViewById<EditText>(R.id.editTextTextPersonName4).text.toString()
                val email = findViewById<EditText>(R.id.editTextTextEmailAddress4).text.toString()
                val num = findViewById<EditText>(R.id.editTextPhone2).text.toString()
                val pass = findViewById<EditText>(R.id.editTextTextPassword3).text.toString()
                val arr : String = email+"!"+name+"!"+num+"!"+pass

                val intent=Intent(this@thirdactivity,secondactivity::class.java)

                intent.putExtra("detail",arr)
                intent.putExtra("mail",email)
                startActivity(intent)

            }
        })
    }
}