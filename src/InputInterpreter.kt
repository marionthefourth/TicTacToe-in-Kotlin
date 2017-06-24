sealed class InputInterpreter {

    enum class InputType { GAMEPLAY,NAMING,REPLAY }

    // Runs a Static Instance of InputInterpreter
    companion object Factory {
        // "Handles" User input for Placing Xs and Os

        fun canHandle(input: String?, type:InputType): Boolean {
            // Check that input length is correct
            if (type == InputType.GAMEPLAY) {
                if (input?.length == 3) {
                    val inputValidated = arrayOf(false, false)
                    val validNumericInputs = arrayOf("0", "1", "2")
                    val validSpecialCharacters = arrayOf(":", "|", ",")

                    validSpecialCharacters.forEach {
                        // Check for special characters and that they are in the proper location
                        if (input.indexOf(it) == 1) {
                            // read numeric values surrounding the special characters and validate input
                            validNumericInputs.forEach {

                                if (input.substring(0,1).toInt() == it.toInt()) inputValidated[0] = true
                                if (input.substring(2,3).toInt() == it.toInt()) inputValidated[1] = true
                            }

                            // Return true if all inputs are valid
                            return !inputValidated.contains(false)
                        }
                    }
                    // Return false if it doesn't contain any of the special characters
                    return false
                } else {
                    // Return false if it doesn't meet length requirements
                    return false
                }
            } else if (type == InputType.NAMING)  {
                return input?.length!! > 1
            } else {
                val acceptableInputs = arrayOf("y","yes","sure","okay","yeah","n","no","nope","nah")

                acceptableInputs.forEach {
                    if (input.equals(it)) {
                        return true
                    }
                }

                return false
            }

        }

        // KP -- playing kotlin
        fun process(input: String?,type: InputType): String {
            var output = "Incorrect Input"
            if (InputInterpreter.canHandle(input,type)) {
                output = input!!
            }
            return output

        }

        fun translateInputToPair(input: String) : Pair<Int,Int> {
            return Pair(input.substring(0,1).toInt(),input.substring(2,3).toInt())
        }
    }

}