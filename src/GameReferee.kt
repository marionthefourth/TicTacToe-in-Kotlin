class GameReferee {

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
                    while (gameplayInputIsInvalid(playerMovePosition,board)) {
                        // TODO - Display Input Error Here
                        playerMovePosition = readLine()
                    }

                    // Fill Spot on Board
                    board.fillSpot(InputInterpreter.translateInputToPair(playerMovePosition!!),player.getMark(index))

                    // Once Either a Player Wins or the Board is Full Game Ends
                    if (matchIsOver(board)) {
                        matchOver = true

                        declareWinner(board,players)

                        return shouldPlayAgain()
                    }
                }
            }

            return false
        }

        private fun  matchIsOver(board: Board) = board.hasCompleteSet().first or board.isFilled()

        private fun  declareWinner(board: Board, players: Array<Player>) {
            if (board.hasCompleteSet().first) {
                players[board.hasCompleteSet().second].wonGame()
                println("And the winner is, ${players[board.hasCompleteSet().second].name}! Congratulations!")
            } else {
                println("And there was a tie!")
            }
        }

        private fun shouldPlayAgain(): Boolean {
            // One Player Must Decide to Play again for new match to begin
            println("Do you want to play again?")

            var response = readLine()

            while (!InputInterpreter.canHandle(response,InputInterpreter.InputType.REPLAY)) {
                // TODO - Display Input Error Here
                response = readLine()
            }

            return InputInterpreter.process(response,InputInterpreter.InputType.REPLAY).equals("yes")
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

        private fun gameplayInputIsInvalid(playerMovePosition:String?, board:Board) :Boolean {
            if (!InputInterpreter.canHandle(playerMovePosition,InputInterpreter.InputType.GAMEPLAY)) {
                return true
            }

            if (!board.spotIsAvailable(InputInterpreter.translateInputToPair(playerMovePosition!!))) {
                return true
            }

            return false
        }

    }
}