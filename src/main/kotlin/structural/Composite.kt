package structural

open class Element(
        val name: String,
        open val price: Int
)

open class ElementComposite(
        name: String
) : Element(name, 0){
    private val elements = mutableListOf<Element>()

    override val price: Int
        get() = elements.sumBy { it.price }

    fun addElement(element: Element) =
            apply { elements.add(element) }

    override fun toString() =
            "Total price is: $price"
}

class PC: ElementComposite("PC")
class CPU: Element("CPU", 1000)
class GPU: Element("GPU", 2000)
class ROM: Element("ROM", 250)
class RAM: Element("RAM", 150)

fun main(){
    val personalComputer = PC()
            .addElement(CPU())
            .addElement(GPU())
            .addElement(ROM())
            .addElement(RAM())
            .addElement(Element("Fun", 50))

    println(personalComputer)
}