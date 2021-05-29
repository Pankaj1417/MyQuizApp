package com.example.quiztrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val Username = intent.getStringExtra("Username")
        username.text = Username

        val totalQuestions = intent.getIntExtra("Total",3)
        val correctAnswers = intent.getIntExtra("Correct",0)

        score.text = "Your score is $correctAnswers out of $totalQuestions"

        finish_button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}