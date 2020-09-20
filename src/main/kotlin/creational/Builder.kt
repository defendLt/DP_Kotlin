package creational

interface Builder{
    fun buildStep1()
    fun buildStep2()
    fun buildStep3()
}

class ProductForBuilder1
class ProductForBuilder2

class Builder1: Builder{
    var result = ProductForBuilder1()
    override fun buildStep1() {
        TODO("Not yet implemented")
    }

    override fun buildStep2() {
        TODO("Not yet implemented")
    }

    override fun buildStep3() {
        TODO("Not yet implemented")
    }

}

class Builder2: Builder{
    var result = ProductForBuilder2()
    override fun buildStep1() {
        TODO("Not yet implemented")
    }

    override fun buildStep2() {
        TODO("Not yet implemented")
    }

    override fun buildStep3() {
        TODO("Not yet implemented")
    }
}