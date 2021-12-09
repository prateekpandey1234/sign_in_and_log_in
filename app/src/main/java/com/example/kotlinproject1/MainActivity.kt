package com.example.kotlinproject1
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    val  logged  = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val map2  :Bundle? = intent.extras
        val bob = findViewById<Button>(R.id.button)
        val bob2 = findViewById<Button>(R.id.button4)
        if(map2 == null){
            Toast.makeText(this,"Please make a new account",Toast.LENGTH_SHORT).show()
            bob.isSaveEnabled=false
            bob.isClickable=false
        }else {

            bob.isSaveEnabled=true
            bob.isClickable=true
            val value = map2?.get("details").toString()
            logged.add(value)
            Log.e("map", value)
            val map = mapOf<String, Integer>()
            val txt = findViewById<EditText>(R.id.editTextTextEmailAddress)
            val pass = findViewById<EditText>(R.id.editTextTextPassword)
            bob.setOnClickListener(object : View.OnClickListener{
                override fun onClick(view: View){
                    if (txt.text.toString() == "" || pass.text.toString() == "") {
                        Toast.makeText(this@MainActivity, "PLEASE GIVE INFO!", Toast.LENGTH_SHORT)
                            .show()
                        txt.text.clear()
                        pass.text.clear()
                    } else {
                        for ( i in logged){
                            val lis = i.split("!")
                            if(lis[0]==txt.text.toString() && lis[3]==pass.text.toString()){
                                val intent = Intent(this@MainActivity, secondactivity::class.java)
                                intent.putExtra("email", txt.text.toString())
                                intent.putExtra("details",i.toString())
                                Log.d("log",i)
                                intent.putExtra("pass", pass.text.toString())
                                startActivity(intent)
                                break
                            }
                            else{
                                Log.d("log","no"+"\\"+lis[0]+"no"+lis[3]+"\\")
                                Log.d("log","no"+"\\"+txt.toString()+"no"+pass.toString()+"\\")
                            }
                        }

                    }

                }
            })
        }


        bob2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, thirdactivity::class.java)
                startActivity(intent)
            }
        })
        val bundle : Bundle? = intent.extras
    }





}


