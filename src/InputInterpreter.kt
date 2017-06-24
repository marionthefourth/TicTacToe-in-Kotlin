

sealed class InputInterpreter {
    companion object Factory {
        fun handle(input: String): Boolean {
            // Check that input length is correct
            if (input.length == 3) {

                var inputValidated = booleanArrayOf(false, false)
                val validNumberInputs = arrayOf("0", "1", "2")
                val validSpecialCharacters = arrayOf(":", "|", ",")

                validSpecialCharacters.forEach {
                    // Check for special characters and that they are in the proper location
                    if (input.contains(it) and (input.indexOf(it) == 1)) {
                        // read numeric values sandwiching the special characters and validate input
                        validNumberInputs.forEach {
                            if (it.get(0).toInt() == it.toInt()) {
                                inputValidated.set(0, true)
                            }

                            if (it.get(2).toInt() == it.toInt()) {
                                inputValidated.set(2, true)

                            }

                        }

                        // Return true if all inputs are valid
                        return !inputValidated.contains(false)
                    }

                    return true
                }
                return true

            } else {
                return false
            }

        }
    }

}
