fun main(args: Array<String>) {
    println("Tic-Tac-Toe")

    for (i in 0..5) {
        println(InputInterpreter.handle("$i:$i"))
    }

}