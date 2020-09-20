package structural

interface Rate {
    fun getPrice(): Int
}

class BaseRate: Rate{
    override fun getPrice(): Int {
        return 10
    }
}

class SaleRate(
        private val rate: Rate
): Rate {
    override fun getPrice(): Int = rate.getPrice()-2
}

class PremiumRate(
        private val rate: Rate
): Rate {
    override fun getPrice(): Int = rate.getPrice()-3
}

fun main(){
    val baseRate = BaseRate()
    val saleRate = SaleRate(baseRate)
    val premiumRate = PremiumRate(saleRate)

    println("baseRate is: ${baseRate.getPrice()}")
    println("saleRate is: ${saleRate.getPrice()}")
    println("premiumRate is: ${premiumRate.getPrice()}")
}