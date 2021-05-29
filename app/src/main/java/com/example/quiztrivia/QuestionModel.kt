package com.example.quiztrivia

data class QuestionModel(
    val id:Int,
    val questionText:String,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)
