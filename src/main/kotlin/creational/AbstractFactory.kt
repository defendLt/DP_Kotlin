package creational

interface Coffee
interface Tea
interface Milk

class Coffee1: Coffee
class Tea1: Tea
class Milk1: Milk

class Coffee2: Coffee
class Tea2: Tea
class Milk2: Milk


interface DrinkFactory{
    fun createCoffee(): Coffee
    fun createTea(): Tea
    fun createMilk(): Milk
}

class DrinkFactory1: DrinkFactory {
    override fun createCoffee(): Coffee = Coffee1()
    override fun createTea(): Tea = Tea1()
    override fun createMilk(): Milk = Milk1()
}

class DrinkFactory2: DrinkFactory {
    override fun createCoffee(): Coffee = Coffee2()
    override fun createTea(): Tea = Tea2()
    override fun createMilk(): Milk = Milk2()
}

fun main(){
    val drinkFactory: DrinkFactory = when(readLine()){
        "factory1" -> DrinkFactory1()
        else -> DrinkFactory2()
    }
}