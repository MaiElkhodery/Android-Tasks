package com.example.kotlinfunctions

fun main() {
    println("Enter the Mood (Happy-Sad) and the Weather (Rainy-Mild-Sunny) :")
    temp(toDo(readln(), readln()))
    temp(toDo())
}
fun toDo(mood : String = "Happy", weather : String = "Mild"):String{
    if(mood=="Happy"&&weather=="Sunny"){
        print("go to swimming")
    }
    else if(mood=="Happy"&&weather=="Rainy"){
        print("Stay and watch your favorite film")
    }
    else if(mood=="Happy"&&weather=="Mild"){
        print("go to gym")
    }
    else if(mood=="Sad"&&weather=="Sunny"){
        print("go to club")
    }
    else if(mood=="Sad"&&weather=="Rainy"){
        print("Play games on computer")
    }
    else if(mood=="Sad"&&weather=="Mild"){
        print("Call your friend and enjoy")
    }
    println()
    return weather
}
fun temp(weather : String){
    if(weather == "Sunny")
        print("temperature from 35 to 50")
    if(weather == "Rainy")
        print("temperature from 10 to 20")
    if(weather == "Mild")
        print("temperature from 20 to 35")
    println()
}
