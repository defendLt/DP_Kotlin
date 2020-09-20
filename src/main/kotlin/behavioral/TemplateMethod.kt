package behavioral

abstract class DataParser{
    fun startPars(){
        openFile()
        parsData()
        convertData()
        saveData()
        closeFile()
    }
    protected abstract fun openFile()
    protected open fun parsData() = println("parsData")
    protected open fun convertData() = println("convertData")
    protected open fun saveData() = println("saveData")
    protected abstract fun closeFile()
}

class DataParser1 : DataParser(){
    override fun openFile() = println("open file for DataParser1")
    override fun convertData() = println("mock step")
    override fun closeFile() = println("close file for DataParser1")
}

class DataParser2 : DataParser(){
    override fun openFile() = println("open file for DataParser2")
    override fun saveData() = println("mock step")
    override fun closeFile() = println("close file for DataParser2")
}

fun main() {
    val dataParser1 = DataParser1()
    val dataParser2 = DataParser2()

    dataParser1.startPars()
    dataParser2.startPars()
}