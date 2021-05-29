package com.example.quiztrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_quiz_btn.setOnClickListener {
            if(name_et.text.toString().isEmpty())
            {
                Toast.makeText(this,
                    "Name cannot be blank",
                Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this,
                    QuestionsActivity::class.java)
                intent.putExtra("Username",name_et.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}