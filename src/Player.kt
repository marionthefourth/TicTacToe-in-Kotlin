class Player {

    var score = 0
    var name = ""
    var mark = " "

    constructor(name:String,score:Int) : this(name) {

        this.score = score
    }

    fun getMark(index:Int) : String {
        if (index == 0) {
            return "X"
        } else {
            return "0"
        }
    }

    fun wonGame() {
        score++
    }

    constructor(name:String) {
        this.name = name
    }

    constructor()

}