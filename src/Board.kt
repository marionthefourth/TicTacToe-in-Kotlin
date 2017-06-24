/**
 * Created by MGR4 on 6/24/17.
 */

class Board {
    val indicies = array2d(3,3) { " " }

    fun spotIsAvailable(position:Pair<Int,Int>):Boolean {

        return indicies[position.first][position.second].equals(" ")
    }

    fun fillSpot(position:Pair<Int,Int>,value:String) {
        indicies[position.first][position.second] = value
        this.print()
    }

    fun isFilled() : Boolean {
         indicies.forEach {
             if (it.contains(" ")) {
                 return false
             }
         }

        return true
    }

    fun hasCompleteSet() : Pair<Boolean,Int> {
        val validInputs = arrayOf(" X ", " O ")
        for (i in 0..validInputs.size-1) {
            // Search Vertically
            if (foundMatchesVertically(validInputs[i])) {
                return Pair(true,i)
            // Search Horizontally
            } else if (foundMatchesHorizontally(validInputs[i])) {
                return Pair(true,i)
            // Search Diagonally
            } else if (foundMatchesDiagonally(validInputs[i])) {
                return Pair(true,i)
            }
        }

        return Pair(false,-1)
    }

    fun foundMatchesHorizontally(mark:String) : Boolean {
        var marksMatching = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (indicies[i][j].equals(mark)) {
                    marksMatching++
                } else {
                    break
                }
            }

            if (marksMatching == 3) {
                return true
            }
        }

        return false
    }

    fun foundMatchesVertically(mark:String) : Boolean {
        var marksMatching = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (indicies[j][i].equals(mark)) {
                    marksMatching++
                } else {
                    break
                }
            }

            if (marksMatching == 3) {
                return true
            }
        }

        return false
    }

    fun foundMatchesDiagonally(mark:String) : Boolean {
        var marksMatching = 0
        for (i in 0..2) {
            if (indicies[i][i].equals(mark)) {
                marksMatching++
            } else {
                break
            }

            if (marksMatching == 3) {
                return true
            }
        }

        for (i in 2..0) {
            var j = i
            if (i == 2) {
                j = 0
            } else if (i == 1) {
                j = 1
            } else {
                j = 2
            }
            if (indicies[i][j].equals(mark)) {
                marksMatching++
            } else {
                break
            }

            if (marksMatching == 3) {
                return true
            }
        }

        return false
    }

    fun print() {
        for (i in 0..2) {
            for (j in 0..2) {
                if (!indicies[i][j].equals(" ")) {
                    print(" ${indicies[i][j]} ")
                } else {
                    print(indicies[i][j])
                }
                if (j != 2) {
                    print(" | ")
                }
            }
            println("")
            if (i != 2) {
                for (l in 0..8) {
                    print("_")
                }
                println("")
            }
        }
    }

}

