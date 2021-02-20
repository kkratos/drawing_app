package com.example.hellokotlin

abstract class Mammal(
    private val name: String,
    private val origin: String,
    private val weight: Double
) {
    //Concrete (Non Abstract) Properties

    //Abstract Property (Must be overriden by SubClasses)
    abstract var maxSpeed: Double

    //Abstract Methods (Must be implemented by Subclasses)
    abstract fun run()
    abstract fun breathe()

    fun displayDetails() {
        println("name:$name, origin:$origin, weight: $weight, " + "max SpeedL $maxSpeed")
    }
}

class Human(name: String, origin: String, weight: Double, override var maxSpeed: Double) :
    Mammal(name, origin, weight) {

    override fun run() {

        println("run on two legs")
    }

    override fun breathe() {
        println("breathe with mouth and nose")
    }
}

class Elephant(name: String, origin: String, weight: Double, override var maxSpeed: Double) :
    Mammal(name, origin, weight) {

    override fun run() {
        println("run on four legs")
    }

    override fun breathe() {
        println("breath through trunk")
    }
}

fun main() {
    val human = Human("Kamal", "India", 70.0, 28.0)
    val elephant = Elephant("Rosy", "Russia", 5400.0, 25.0)

    human.run()
    elephant.run()

    human.breathe()
    elephant.breathe()
}