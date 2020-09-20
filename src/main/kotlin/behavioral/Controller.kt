package behavioral

interface BaseController{
    fun sendNotify(sender: BaseComponent)
}

sealed class BaseComponent(baseController: BaseController){
    class Component1(baseController: BaseController): BaseComponent(baseController)
    class Component2(baseController: BaseController): BaseComponent(baseController)
    class Component3(baseController: BaseController): BaseComponent(baseController)
    class Component4(baseController: BaseController): BaseComponent(baseController)
}

class ComponentController: BaseController {
    override fun sendNotify(sender: BaseComponent) {
        when(sender){
            is BaseComponent.Component1 -> {}
            is BaseComponent.Component2 -> {}
            is BaseComponent.Component3 -> {}
            is BaseComponent.Component4 -> {}
        }
    }
}