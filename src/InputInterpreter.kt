sealed class InputInterpreter {

    // Runs a Static Instance of InputInterpreter
    companion object Factory {
        // "Handles" User input for Placing Xs and Os

        fun handle(input: String): Boolean {
            // Check that input length is correct
            if (input.length == 3) {
                val inputValidated = arrayOf(false, false)
                val validNumericInputs = arrayOf("0", "1", "2")
                val validSpecialCharacters = arrayOf(":", "|", ",")

                validSpecialCharacters.forEach {
                    // Check for special characters and that they are in the proper location
                    if (input.indexOf(it) == 1) {
                        // read numeric values surrounding the special characters and validate input
                        validNumericInputs.forEach {

                            if (input.substring(0,1).toInt() == it.toInt()) inputValidated.set(0, true)
                            if (input.substring(2,3).toInt() == it.toInt()) inputValidated.set(1, true)
                        }

                        // Return true if all inputs are valid
                        return !inputValidated.contains(false)
                    }
                }
                // Return false if it doesn't contain any of the special characters
                return false
            } else {
                // Return false if it doesn't meet length requirements
                return input.length == 3
            }
        }
        // KP -- playing kotlin
        fun process(input: String): String {
            var output = "Incorrect Input"
            if (InputInterpreter.handle(input)) {
                output = input
            }
            return output
        }
    }

}
