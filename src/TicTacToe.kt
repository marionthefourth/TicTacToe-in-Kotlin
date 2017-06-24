fun main(args: Array<String>) {
    println("Tic-Tac-Toe")

    for (i in 0..5) {
        for (j in 0..5) {
            print("$i:$j ${
            InputInterpreter.handle("$i:$j")
            } ")
        }
        println()
    }
}