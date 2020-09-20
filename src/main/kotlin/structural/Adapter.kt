package structural

interface InformData {
    fun getInform(): String
}

class DomainData(
        private val apiData: ApiData
) : InformData {
    override fun getInform(): String = "data is: ${apiData.data1 + apiData.data2}"
}

class ApiData(
        val data1: Int,
        val data2: Int
)

fun main() {
    val apiData = ApiData(1, 2)
    val informData = DomainData(apiData)
    println(informData.getInform())
}