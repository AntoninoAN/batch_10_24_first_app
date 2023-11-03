package com.example.firstapp

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Test {
    val name = "Tony"
    var lastName = "Ardines"
    private var language = "Kotlin"


    fun update(newLanguage: String) {
        language = newLanguage
    }

    operator fun getValue(person: Person, property: KProperty<*>): String {
        return ""
    }

    companion object {
        const val THIS_IS_CONSTANT = "SomeConstantValue"
        fun someStatic() = "This is static!"
    }

}

class Person(val firstName: String, val lastName: String) {
    constructor(firstName: String,
                lastName: String,
                ssn: String): this(firstName, lastName) {
                    this.ssn = ssn
                }
    lateinit var ssn: String

    val userId: Int by lazy {
        println("First timer")
        0
    }

    val test2: String = ""

    init {
        if (::ssn.isInitialized)
        println(ssn.length)
        else
        ssn = "Some value"
        //
        println(userId)// first timer || 0

        println(userId)// 0
    }

    constructor(firstName: String,
                lastName: String,
                address: ApiResponse): this(firstName, lastName) {

                }
    var another: String
    init {
        another = userId.toString()
    }

}

open class Shape(val size: Int) {
    open fun calculate(formulae: String) = 4
}

class Rectangle(size: Int, private val area: Int): Shape(size) {

    override fun calculate(formulae: String): Int {
        return super.calculate(formulae)
    }
}


data class ApiResponse(val listOfData: List<String>,
                       val pageNumber: Int): Communicator { // ApiResponse[listOfData, 1]
    override fun sendData(theData: String) {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return StringBuilder().append("My class\n").append("").toString()
    }
}

sealed class State {
    data class Success(val response: ApiResponse): State()
    data class Loading(val isLoading: Boolean): State()
}

sealed interface RepositoryTypes{
    class TestRepository: RepositoryTypes {
        fun returnData() = listOf<String>("")
    }
    class ProductionRepository: RepositoryTypes
}

enum class Sport {
    SOCCER, BASEBALL, FOOTBALL,
}
interface Communicator {
    fun sendData(theData: String)
}

fun main() {
    val testInstance = Test()
    testInstance.lastName = ""
    testInstance.update("Swift")
    Test().name
    Test.THIS_IS_CONSTANT
    Test.someStatic()
    val  persone: Person? = Person("","","")


    persone?.favoriteSport(Sport.SOCCER) ?: throw Exception("Unknown error")
    persone.myNewFunction()


    // Java
    val javaTest = JavaTest()
    javaTest.name
    JavaTest.foo()
    Another()
    ThirdClass("")
    ThirdClass()
}

fun Any.myNewFunction(): String {
return ""
}

fun Person.favoriteSport(selectedSport: Sport) = when (selectedSport) {
        Sport.BASEBALL -> "incorrect selection"
        Sport.SOCCER -> "the only selection"
        Sport.FOOTBALL -> "incorrect selection"
    }


fun foo(){

}

object Singleton {}

const val THIS_IS_ALSO_STATIC = ""