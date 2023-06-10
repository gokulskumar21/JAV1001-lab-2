fun main()
{

    println("************** Functions and Arrays ********************")
    println("1-> Encrypting using Caesar cipher")
    println("2-> Average of an integer array")
    println("3-> Check if an array has a value")
    println("4-> Reversing an array")
    print(" Please choose one option from above: ")
    val option = readLine()!!.toInt()//changed

    if (option <= 4)
    {
        when (option)
        {
            1 ->
            {
                println("Enter the string you need to encrypt")
                val stringInput = readLine()
                println("Enter the number of places you need to shift(numeric value)")
                val shift = readLine()!!.toInt()
                if (stringInput != null && shift != null)
                {
                    val encryptedString = caesarCipher(stringInput, shift)
                    println("Encrypted string is: $encryptedString")
                } else {
                    println("Enter a valid input.")
                }
            }
            2 -> {
                println("Enter the array you need to find average(array should be numeric and seperated by space)")
                val arrayInput = readLine()
                val splitArray = arrayInput?.let { it ->  //used to split the entered input into array of integers
                    it.split(" ").mapNotNull { str ->
                        str.toIntOrNull()
                    }.toIntArray()
                }
                if (splitArray != null && splitArray.isNotEmpty()) {
                    val averageArray = calculateAverage(splitArray)
                    println("Average is: $averageArray")
                }
            }
            3 -> {
                println("Enter the array that you need to search into(array should be numeric seperated by space)")
                val arrayInput = readLine()
                val splitArray = arrayInput?.let { it ->  //used to split the entered input into array of integers so that we can easily search by each element
                    it.split(" ").mapNotNull { str ->
                        str.toIntOrNull()
                    }.toIntArray()
                }
                if (splitArray != null && splitArray.isNotEmpty()) {
                    println("Enter the element you need to search") //if the splitted array is not empty then we proceed to search the value
                    val searchValue = readLine()!!.toInt()
                    if (searchValue != null) {
                        val containsValue = containsValue(splitArray, searchValue)
                        if (containsValue) //to check if the array contains the value
                        {
                            println("$searchValue is found in $arrayInput")
                        } else {
                            println("$searchValue is not found in $arrayInput")
                        }
                    }
                }

            }
            4 -> {
                println("Enter the array that you want to reverse(array should be numeric seperated by space)")
                val arrayInput = readLine()
                val splitArray = arrayInput?.let { it ->  //used to split the entered input into array of integers so that we can easily reverse the array
                    it.split(" ").mapNotNull { str ->
                        str.toIntOrNull()
                    }.toIntArray()
                }
                if (splitArray != null && splitArray.isNotEmpty()) {
                    val reverseArray = reverseArray(splitArray)
                    println("Reversed array is ${reverseArray.joinToString(", ")} ")
                }
                else{
                    println("Enter a valid input")
                }


            }


        }

    }
    else  println("Enter a valid input") //executed when the user input doesn't matches with the listed values

}
/*
fun caesarCipher(input: String, shift: Int): String {
    var result = ""

    for (char in input) {
        if (char.isLetter()) {
            val base = if (char.isLowerCase()) 'a' else 'A'
            val offset = (char - base + shift) % 26
            val shiftedChar = (base + offset).toChar()
            result += shiftedChar
        } else {
            result += char
        }
    }

    return result
}



fun calculateAverage(array: IntArray): Double {
    val sum = array.sum()
    return sum.toDouble() / array.size
}
 fun containsValue(array: IntArray, value: Int): Boolean {

    return value in array
}

fun reverseArray(array: IntArray): IntArray {
    val reversed = IntArray(array.size)
    for (i in array.indices) {
        reversed[i] = array[array.size - i - 1]
    }
    return reversed
}*/