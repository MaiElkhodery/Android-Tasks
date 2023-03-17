package com.example.final_kotlin_task

fun main() {
    val st_id = readLine().toString()
    val st_name = readLine().toString()
    val st_material = readLine().toString()
    val st_degreeOfmaterial = readLine().toString().toInt()
    val st_dr = readLine().toString()
    val st_drDays = readLine().toString().toInt()
    val st : ID = ID(st_id,st_name,st_material,st_degreeOfmaterial);
    val dr : Doctor = Doctor(st_dr,st_drDays)
    st.displayNameAndId()
    st.displayMaterialAndDegree()
    dr.dr()
    dr.drDays()
}
class Doctor(private val name : String,private val noOfDays : Int ){
    fun dr(){
       println("Doctor $name")
    }
    fun drDays(){
        println("Available Days $noOfDays")
    }
}
class ID(private val id : String,private val name : String,private val material : String
    ,private val degreeOfMaterial : Int){

    fun displayNameAndId(){
        println("ID $id, Name $name")
    }
    fun displayMaterialAndDegree(){
        println("Material $material, Degree $degreeOfMaterial")
    }
}