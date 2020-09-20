package behavioral

interface Strategy{
    fun run()
}
class Strategy1: Strategy{
    override fun run() = println("Strategy1")
}
class Strategy2: Strategy{
    override fun run() = println("Strategy2")
}
class ContextEx1(
    private var strategy: Strategy
){
    fun run(){
        strategy.run()
    }
    fun changeStrategy(strategy: Strategy){
        this.strategy = strategy
    }
}

class ContextEx2(
    private var strategy: (String) -> Unit
){
    fun run(text: String){
        strategy(text)
    }

    fun changeStrategy(strategy: (String) -> Unit){
        this.strategy = strategy
    }
}

fun main(){

    //Example №1
    val strategy1 = Strategy1()
    val strategy2 = Strategy2()

    val contextEx1 = ContextEx1(strategy1)
    contextEx1.run()
    contextEx1.changeStrategy(strategy2)
    contextEx1.run()

    //Example №2
    val strategyEx1 : (String) -> Unit = { println(it.toUpperCase()) }
    val strategyEx2 = {it: String -> println(it.toLowerCase())}

    val contextEx2 = ContextEx2(strategyEx1)
    contextEx2.run("strategyEx1")
    contextEx2.changeStrategy(strategyEx2)
    contextEx2.run("strategyEx2")
}