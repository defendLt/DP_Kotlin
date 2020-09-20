package creational

//Example №1
interface Product
class Product1 : Product
class Product2 : Product

abstract class ProductCreator{
    fun getNeedProduct(): Product {
        return createProduct()
    }
    abstract fun createProduct(): Product
}
class ProductCreator1: ProductCreator() {
    override fun createProduct(): Product = Product1()
}
class ProductCreator2: ProductCreator() {
    override fun createProduct(): Product = Product2()
}

fun main(){

}