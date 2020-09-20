package behavioral

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

interface Subscriber {
    fun notifySub()
}

interface Publisher {
    fun addSub(subscriber: Subscriber)
    fun remSub(subscriber: Subscriber)
}

data class Subscriber1(
        private val name: String
): Subscriber{
    override fun notifySub() {
        println("$name received notification")
    }
}

class Publisher1 : Publisher {
    private val subList: MutableList<Subscriber> = mutableListOf()
    var pubState = false
        set(state: Boolean) {
            field = state
            notifySubs()
        }

    override fun addSub(subscriber: Subscriber) {
        subList.add(subscriber)
    }

    override fun remSub(subscriber: Subscriber) {
        subList.remove(subscriber)
    }

    private fun notifySubs() {
        subList.forEach { it.notifySub() }
    }

}

fun main(){
    val publisher1 = Publisher1()
    val subscribers: MutableList<Subscriber> = mutableListOf()
    (1..9).forEach{
        val sub = Subscriber1("name:$it")
        subscribers.add(sub)
        publisher1.addSub(sub)
    }

    runBlocking {
        launch { // launch a new coroutine in background and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            publisher1.pubState = true
            println("\nend first\n")
            subscribers.filterIndexed{i,_ -> i>4}.forEach {
                publisher1.remSub(it)
                println("$it unsubscribe")
            }
            println()
            delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
            publisher1.pubState = false
        }
    }
}