package behavioral

open class Editor(
        private var string1: String,
        private var string2: String,
        private var string3: String
){
    fun saveState() : Snapshot {
        return Snapshot(string1, string2, string3)
    }
    fun restoreState(snapshot: Snapshot){
        snapshot.let {
            string1 = it.string1
            string2 = it.string2
            string3 = it.string3
        }
    }
    inner class Snapshot(
            val string1: String,
            val string2: String,
            val string3: String
    )
}
class CareTaker{
    private val mementoList: MutableList<Editor.Snapshot> = mutableListOf()

    fun saveState(moment: Editor.Snapshot){
        mementoList.add(moment)
    }

    fun restoreState(index: Int) : Editor.Snapshot {
        return mementoList[index]
    }
}

fun main(){
    val careTaker = CareTaker()
    val editor = Editor("s1", "s2", "s3")

    careTaker.saveState(editor.saveState())
    editor.restoreState(careTaker.restoreState(0))
}