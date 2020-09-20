package behavioral

class BusinessLogic{
    fun setOn() = true
    fun setOff() = false
}

interface BaseCommand{
    fun execute()
}
data class Command1(
        private val businessLogic: BusinessLogic
): BaseCommand {
    override fun execute() {
        businessLogic.setOn()
    }
}
data class Command2(
        private val businessLogic: BusinessLogic
): BaseCommand {
    override fun execute() {
        businessLogic.setOff()
    }
}

class CommandInvoker{
    private val commandStack = mutableMapOf<String, BaseCommand>()

    fun register(commandName: String, command: BaseCommand){
        commandStack[commandName] = command
    }

    fun execute(commandName: String){
        commandStack.remove(commandName)
    }
}

fun main(){
    val businessLogic = BusinessLogic();
    val command1 = Command1(businessLogic)
    val command2 = Command2(businessLogic)
    val commandInvoker = CommandInvoker()

    commandInvoker.run {
        register("firstCommand", command1)
        register("lastCommand", command2)

        execute("firstCommand")
        execute("lastCommand")
    }
}