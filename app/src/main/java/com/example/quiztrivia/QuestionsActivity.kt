package com.example.quiztrivia

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition:Int = 1
    private var questionsList:ArrayList<QuestionModel>? = null
    private var selectedOptionPosition:Int = 0
    private var countCorrectAnswers:Int = 0
    private var userName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        userName = intent.getStringExtra("Username")

        questionsList = QuestionController.getQuestions()
        setQuestion()

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submit_button.setOnClickListener(this)

    }

    fun setQuestion()
    {
        val question:QuestionModel = questionsList!![currentPosition-1]
        optionDefaultBackground()

        if(currentPosition == questionsList!!.size)
        {
            submit_button.text = "FINISH"
        }

        progressBar.progress = currentPosition
        progress_textview.text = "$currentPosition/${questionsList!!.size}"

        question_text.text = question.questionText
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour
    }

    fun optionDefaultBackground()
    {
        val optionsArrayList = ArrayList<TextView>()
        optionsArrayList.add(option_one)
        optionsArrayList.add(option_two)
        optionsArrayList.add(option_three)
        optionsArrayList.add(option_four)
        for (option in optionsArrayList)
        {
            option.background = ContextCompat.getDrawable(this,
                R.drawable.option_border)
            option.setTextColor(Color.parseColor("#563036"))
        }

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.option_one -> {
                optionSelectedBackground(option_one,1)
            }
            R.id.option_two -> {
                optionSelectedBackground(option_two,2)
            }
            R.id.option_three -> {
                optionSelectedBackground(option_three,3)
            }
            R.id.option_four -> {
                optionSelectedBackground(option_four,4)
            }
            R.id.submit_button -> {
                if(selectedOptionPosition==0)
                {
                    currentPosition++
                    when {
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,FinalActivity::class.java)
                            intent.putExtra("Username",userName)
                            intent.putExtra("Correct",countCorrectAnswers)
                            intent.putExtra("Total",questionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
                else
                {
                    val question = questionsList!![currentPosition-1]
                    if(question.correctAnswer != selectedOptionPosition)
                    {
                        redGreenHighlight(selectedOptionPosition,R.drawable.wrong_answer)
                    }
                    else
                    {
                        countCorrectAnswers++
                    }
                    redGreenHighlight(question.correctAnswer,R.drawable.correct_answer)
                    selectedOptionPosition = 0

                }
            }
        }
    }

    fun redGreenHighlight(answer:Int,drawable:Int)
    {
        when(answer) {
            1 -> {
                option_one.background = ContextCompat.getDrawable(this,
                                                    drawable)
            }
            2 -> {
                option_two.background = ContextCompat.getDrawable(this,
                    drawable)
            }
            3 -> {
                option_three.background = ContextCompat.getDrawable(this,
                    drawable)
            }
            4 -> {
                option_four.background = ContextCompat.getDrawable(this,
                    drawable)
            }
        }
    }

    fun optionSelectedBackground(tv:TextView,selectedOptionNo:Int)
    {
        optionDefaultBackground()
        selectedOptionPosition = selectedOptionNo
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option)
        tv.setTextColor(Color.parseColor("#FFFFFF"))
    }
}