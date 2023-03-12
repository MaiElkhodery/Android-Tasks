package com.example.kotlin_datastructures

fun main() {
    val data = listOf(
        listOf("Mahmoud", "Football", 20, "Engineering"),
        listOf("Mohammed", "Basketball", 25, "Science"),
        listOf("Suzan", "Volleyball", 18, "CIS"),
        listOf("Alaa", "Karate", 32, "Medicine"),
        listOf("Zeinab", "Chess", 27, "Pharmacy")
    )

    val nameList = mutableListOf<String>()
    val gameList = mutableListOf<String>()
    val ageList = mutableListOf<Int>()
    val collegeList = mutableListOf<String>()

    for (item in data) {
        nameList.add(item[0] as String)
        gameList.add(item[1] as String)
        ageList.add(item[2] as Int)
        collegeList.add(item[3] as String)
    }

    var input: String
    var name: String
    var game: String
    var age: Int
    var college: String

    do {
        println("Enter a name to get their data or type 'FINISH' to exit:")
        input = readLine()!!.toString()

        if (nameList.contains(input)) {
            val index = nameList.indexOf(input)
            name = nameList[index]
            game = gameList[index]
            age = ageList[index]
            college = collegeList[index]

            println("$name plays $game and is $age years old. They attend $college.")

        } else if (input != "FINISH") {
            println("Invalid input")
        }

    } while (input != "FINISH")
}