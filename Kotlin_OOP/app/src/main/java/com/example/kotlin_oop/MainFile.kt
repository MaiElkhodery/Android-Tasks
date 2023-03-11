package com.example.kotlin_oop

fun main() {

    print("Choose a number from 1 to 4 : ")
    val num = readLine()?.toInt()
    when(num){
        1 -> {
            val football = Football()
            football.displayInfo()
        }
        2 -> {
            val basketball = Basketball()
            basketball.displayInfo()
        }
        3 -> {
            val karate = Karate()
            karate.displayInfo()
        }
        4 -> {
            val chess = Chess()
            chess.displayInfo()
        }
        else -> print("Invalid Number")
    }
}
open class Game(name : String, players:Int, ball : Boolean, status : String ){
    var nameOfGame : String = name
    val numOfPlayers : Int = players
    var gameBall : Boolean = ball
    var gameStatus : String=status
    fun displayInfo(){
        println("$nameOfGame, $numOfPlayers, ${if(gameBall) "have a ball" else "have no ball"} " +
                ", $gameStatus")
    }
}
class Football(): Game("Football", 11, true, "Collective" ){
}
class Basketball(): Game("Basketball", 5, true, "Collective"){

}
class Karate(): Game("Karate", 1, false, "Individually" ){

}
class Chess(): Game("Chess", 1, false, "Individually" ){
}