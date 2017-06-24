sealed class Player(name:String) {

    var name = name
    var score = 0

    constructor(name:String,score:Int) : this(name) {
        this.score = score
    }

    fun wonGame() {
        score++
    }

}