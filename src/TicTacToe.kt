fun main(args: Array<String>) {
    println("Tic-Tac-Toe")

    GameReferee.newTicTacToeGame(arrayOf(Player(),Player()),Board())

}

fun BoardTests() {
    val board = Board()

    board.print()
}

fun InputInterpreterTests() {
    for (i in 0..4) {
        for (j in 0..4) {
            print(InputInterpreter.process("$i:$j",InputInterpreter.InputType.GAMEPLAY))
            print(" ")
        }
        println()

        for (i in 0..5) {
            println("${InputInterpreter.canHandle("$i:$i", InputInterpreter.InputType.GAMEPLAY)}")
            println("i" + 1 + '5')
        }
    }
}