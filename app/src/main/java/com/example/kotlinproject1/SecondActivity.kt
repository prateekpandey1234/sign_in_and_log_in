package com.example.kotlinproject1
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class secondactivity : AppCompatActivity(){
    var map2 =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        val bob = findViewById<Button>(R.id.button)
        val bundle  = intent.extras
        val check  = bundle?.containsKey("email")
        if(check == true){
            val map1  = bundle!!.get("details").toString()
            map2=map1
            val lis = map1.split("!")
            val email2 = lis[0]
            val pass2 = lis[3]
            val name = lis[1]
            val phone = lis[2]
            Log.d("list value",lis.toString())

            findViewById<TextView>(R.id.textView).text=name
            findViewById<TextView>(R.id.textView2).text=email2
            findViewById<TextView>(R.id.textView3).text=phone
            findViewById<TextView>(R.id.textView4).text=pass2

        }else {
            val map1 = bundle!!.get("detail").toString()
            map2=map1
            val mail = bundle!!.get("mail").toString()
            val lis = map1.split("!")

            val email1 = bundle!!.get("email")
            val pass1 = bundle!!.get("pass")

            val email2 = lis[0]
            val pass2 = lis[3]
            val name = lis[1]
            val phone = lis[2]
            Log.d("list value", lis.toString())

            findViewById<TextView>(R.id.textView).text = name
            findViewById<TextView>(R.id.textView2).text = email2
            findViewById<TextView>(R.id.textView3).text = phone
            findViewById<TextView>(R.id.textView4).text = pass2
        }

        bob.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View){

                val intent= Intent(this@secondactivity,MainActivity::class.java)
                intent.putExtra("details",map2)
                Log.d("mapp",map2)
                startActivity(intent)
            }
        })
    }

}