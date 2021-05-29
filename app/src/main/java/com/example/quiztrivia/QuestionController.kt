package com.example.quiztrivia

object QuestionController {

    fun getQuestions():ArrayList<QuestionModel> {

        val questionsList = ArrayList<QuestionModel>()

        val q1 = QuestionModel(
            1,
            "What is part of a database that holds only one type of information ?",
            "Report", "Field", "Record", "File",
            2
        )
        questionsList.add(q1)

        val q2 = QuestionModel(
            2,
            "What is the full form of OS in Computer Science ?",
            "Order of Significance", "Open Software",
            "Operating System", "Optical Sensor",
            3
        )
        questionsList.add(q2)

        val q3 = QuestionModel(
            3,
            "Which among these is a JS library ?",
            "ReactJS", "Laravel", "Django", "MySQL",
            1
        )
        questionsList.add(q3)

//        val q3 = QuestionModel(
//            3,
//            "Which among these is a JS library ?",
//            "ReactJS", "Laravel", "Django", "MySQL",
//            1
//        )
//        questionsList.add(q3)


        return questionsList
    }
}