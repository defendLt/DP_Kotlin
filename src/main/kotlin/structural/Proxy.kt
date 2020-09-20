package structural

interface LoadVideoService{
    fun download()
    fun upload()
}

class ApiVideoLoader: LoadVideoService{
    override fun download() = TODO("Not yet implemented")
    override fun upload() = TODO("Not yet implemented")
}

class DbVideoLoader(
        private val loadVideoService: LoadVideoService
): LoadVideoService{
    override fun download() {
        loadVideoService.download()
    }
    override fun upload() {
        loadVideoService.upload()
    }
}