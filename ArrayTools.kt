fun main() {
    var repeat = true //Boolean value set to 'true' so that the while loop executes until the value becomes false
    while(repeat) { //as long as the repeat value is true the while loop executes

        println("************** Functions and Arrays ********************")
        println("1-> Encrypting using Caesar cipher")
        println("2-> Average of an integer array")
        println("3-> Check if an array has a value")
        println("4-> Reversing an array")
        print("Please choose one option from above: ")
        val option = readLine()!!.toIntOrNull()

        if (option != null && option <=4) //check whether the input entered by the user is not null and <=4 and if the user enter a invalid input then else statement correspons to the if will execute
        {
            when (option) {
                1 ->{//if the user input = 1 then this case will execute
                    println("Enter the string you need to encrypt")
                    val stringInput = readLine()
                    println("Enter the number of places you need to shift (numeric value)")
                    val shift = readLine()!!.toIntOrNull()
                    if (stringInput != null && shift != null) {
                        val encryptedString = caesarCipher(stringInput, shift)
                        println("Encrypted string is: $encryptedString")
                    }
                    else {
                        println("Enter valid input.")
                    }
                }

                2 -> {//if the user input = 2 then this case will execute
                    println("Enter the array you need to find average (array should be numeric and separated by space)")
                    val arrayInput = readLine()
                    val splitArray = arrayInput?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
                    if (splitArray != null && splitArray.isNotEmpty()) {
                        val averageArray = calculateAverage(splitArray)
                        println("Average is: $averageArray")
                    }
                    else {
                        println("Enter valid input.")
                    }
                }

                3 -> {//if the user input = 3 then this case will execute
                    println("Enter the array that you need to search into (array should be numeric separated by space)")
                    val arrayInput = readLine()
                    val splitArray = arrayInput?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
                    if (splitArray != null && splitArray.isNotEmpty()) {
                        println("Enter the element you need to search")
                        val searchValue = readLine()?.toIntOrNull()
                        if (searchValue != null) {
                            val containsValue = containsValue(splitArray, searchValue)
                            if (containsValue) {
                                println("$searchValue is found in $arrayInput")
                            }
                            else {
                                println("$searchValue is not found in $arrayInput")
                            }
                        } else {
                            println("Enter a valid input.")
                        }
                    }
                    else {
                        println("Enter valid input.")
                    }
                }

                4 -> {//if the user input = 4 then this case will execute
                    println("Enter the array that you want to reverse (array should be numeric separated by space)")
                    val arrayInput = readLine()
                    val splitArray = arrayInput?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
                    if (splitArray != null && splitArray.isNotEmpty()) {
                        val reverseArray = reverseArray(splitArray)
                        println("Reversed array is ${reverseArray.joinToString(", ")}")
                    }
                    else {
                        println("Enter valid input.")
                    }
                }
            }
        }
        else {
            println("Enter a valid input.")
        }
        println("Press q to exit and y to do further conversion") // Through this statement it helps the user to determine whether to continue or exit the process
        val quit = readLine() //introducing a new constant that helps the user to take decision such as continue or quit
        if (quit == "q") {
            repeat = false //if user enters 'q' then repeat is set to 'false' which means it exit the while loop and program terminates
        }
    }
}
//function to shift the space according to user prefernce
fun caesarCipher(input: String, shift: Int): String {
    var result = ""

    for (char in input) {
        if (char.isLetter()) {
            val base = if (char.isLowerCase()) 'a' else 'A'
            val offset = (char - base + shift) % 26
            val shiftedChar = (base + offset).toChar()
            result += shiftedChar
        }
        else {
            result += char
        }
    }

    return result
}
//function to calculate the average of the integer array
fun calculateAverage(array: IntArray): Double {
    val sum = array.sum()
    return sum.toDouble() / array.size
}
//function to check a particular value in the array
fun containsValue(array: IntArray, value: Int): Boolean {
    return value in array
}
//function to reverse a user inputted integer array
fun reverseArray(array: IntArray): IntArray {
    val reversed = IntArray(array.size)
    for (i in array.indices) {
        reversed[i] = array[array.size - i - 1]
    }
    return reversed
}
