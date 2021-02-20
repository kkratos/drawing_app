package com.example.hellokotlin

import java.lang.IllegalArgumentException

data class User(val id: Long, var name: String)

/*
fun main() {
    val user1 = User(id = 1, name = "Denis")

    user1.name = "micheal"

    val user2 = User(1, "Micheal")
    println(user1.equals(user2))
    println("User Details: $user1")

    val updateUser = user1.copy(name = "Denis Panjuta")
    println(user1)
    println(updateUser)

    println(updateUser.component1()) //print1
    println(updateUser.component2())

    val (id, name) = updateUser
    println("id=$id, name=$name")
}
*/

//The class that inherits the features of another
//class is called the sub class or child class or
//Derived class and the class whose featues are
//inherited is called the super class or parent class
// or Base class.

interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("The drivable is braking")
    }
}

//Vehicles is the superclass, parent class or Base class
open class Vehicle(override val maxSpeed: Double, val name: String, val brand: String) : Drivable {
    //properties
    //methods
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }
    }

    //drive from intarface we are extending
    override fun drive(): String {
        return "driving the interface drive"
    }

    open fun drive(distance: Double) {
        println("Drove for $distance KM")
    }
}

//Sub class, child class or derived class of carVehicle
class ElectricCar(maxSpeed: Double, name: String, brand: String, batteryLife: Double) : Vehicle(maxSpeed, name, brand) {

    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance KM on electricity")
    }

    override  fun drive():String {
        return "Drove for $range KM on electricity"
    }

    override fun brake() {
        super.brake()
        println("Brake inside the electric car  ")
    }
}

//Any class inherits from the Any Class
fun main() {
    var audi3 = Vehicle(200.0, name = "A3", "Audi")
    var tesla = ElectricCar(240.0, name = "S-model", "Tesla", 85.0)

    //tesla.extendRange(300.0)

    tesla.drive()
    tesla.brake()
    audi3.brake()

    //audi3.drive(200.0)
    //tesla.drive(400.0)


}