package behavioral

interface Visitor{
    fun visit(product: Product1)
    fun visit(product: Product2)
}

interface Product{
    fun accept (visitor: Visitor)
}

data class Product1(
    val name: String,
    val number: Int
) : Product{
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

data class Product2(
    val name: String,
    val name2: String
) : Product{
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Visitor1: Visitor{
    override fun visit(product: Product1) =
        println("Name is ${product.name}, number is ${product.number}")

    override fun visit(product: Product2) =
        println("Name is ${product.name} ${product.name2}, not number")
}

class Visitor2: Visitor{
    override fun visit(product: Product1) =
        println("Name is ${product.name}-${product.number}")

    override fun visit(product: Product2) =
        println("Name is ${product.name}-${product.name2}")
}

fun main(){
    val product1 = Product1("name1", 55)
    val product2 = Product2("name2", "name22")
    val products = arrayOf(product1, product2)

    val visitor1 = Visitor1()
    val visitor2 = Visitor2()

    //First visitor
    products.forEach { it.accept(visitor1) }
    //Second visitor
    products.forEach { it.accept(visitor2) }
}