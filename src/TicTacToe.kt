fun main(args: Array<String>) {
    println("Tic-Tac-Toe")

    for (i in 0..4){
        for (j in 0..4){
           print(InputInterpreter.process("$i:$j"))
           print(" ")
        }
        println()
    }
}