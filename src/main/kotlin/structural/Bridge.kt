package structural

interface Device{
    fun onStart()
    fun onPause()
    fun onStop()
}

class Device1: Device{
    override fun onStart() = TODO("Not yet implemented")
    override fun onPause() = TODO("Not yet implemented")
    override fun onStop() = TODO("Not yet implemented")
}

class Device2: Device{
    override fun onStart() = TODO("Not yet implemented")
    override fun onPause() = TODO("Not yet implemented")
    override fun onStop() = TODO("Not yet implemented")
}

open class Controller(
        private val device: Device
){
    fun startDevice() = device.onStart()
    fun stopDevice() = device.onStop()
    fun pauseDevice() = device.onPause()
}

class AdvanceController(
        private val device: Device
) : Controller(device){
    fun rebootDevice(){
        device.onStop()
        device.onStart()
    }
}