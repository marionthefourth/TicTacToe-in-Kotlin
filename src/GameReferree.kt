class GameReferree {

    companion object Factory{
        fun newTicTacToeGame(players:Array<Player>, board:Board) {
            createPlayers(players)

            // Begin Series of Matches
            var shouldContinuePlaying = true
            while (shouldContinuePlaying) {
                shouldContinuePlaying = beginNewMatch(players,board)
            }

        }

        private fun beginNewMatch(players:Array<Player>, board : Board) : Boolean {
            var matchOver = false

            while (!matchOver) {
                players.forEachIndexed { index, player ->
                    println("Your move, ${player.name}!")
                    // Ensure Player Inputs Proper Data

                    var playerMovePosition = readLine()

                    // Keep requesting Input while Player Inputs Invalid Position or Unavailable Position
                    while (!InputInterpreter.canHandle(playerMovePosition,InputInterpreter.InputType.GAMEPLAY)) {
                        // TODO - Display Input Error Here
                        while (!board.spotIsAvailable(InputInterpreter.translateInputToPair(playerMovePosition!!))) {
                            playerMovePosition = readLine()
                        }

                    }

                    // Fill Spot on Board
                    board.fillSpot(InputInterpreter.translateInputToPair(playerMovePosition!!),player.getMark(index))

                    // Once Either a Player Wins or the Board is Full Game Ends
                    if (board.hasCompleteSet().first or board.isFilled()) {

                        matchOver = true

                        // TODO - Declare Winner if Any
                        if (board.hasCompleteSet().first) {
                            println("And the winner is, ${players[board.hasCompleteSet().second].name}! Congratulations!")
                        } else {
                            println("And there was a tie!")
                        }

                        // TODO - Allow New Match
                        // One Player Must Decide to Play again for new match to begin
                        println("Do you want to play again?")

                        var response = readLine()

                        while (!InputInterpreter.canHandle(response,InputInterpreter.InputType.REPLAY)) {
                            // TODO - Display Input Error Here
                            response = readLine()
                        }

                        return InputInterpreter.process(response,InputInterpreter.InputType.REPLAY).equals("yes")
                    }
                }
            }

            return false
        }

        private fun createPlayers(players:Array<Player>) {
            for (i in 0..1) {
                println("What is Player ${i+1}'s Name?")

                var input = readLine()
                while (!InputInterpreter.canHandle(input,InputInterpreter.InputType.NAMING)) {
                    // TODO - Display Input Error
                    input = readLine()
                }

                players.set(i,Player(input!!))
            }

        }

    }
}