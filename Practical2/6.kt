import java.util.Scanner
import java.util.ArrayList

fun reverseList(numbers: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    var i = numbers.size - 1
    while (i >= 0) {
        result.add(numbers[i])
        i--
    }
    return result
}

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter integers separated by spaces: ")
    val input = scanner.nextLine()
    
    // Manual string splitting and parsing
    val numbers = ArrayList<Int>()
    var currentNumber = ""
    
    var i = 0
    while (i < input.length) {
        val char = input[i]
        if (char == ' ') {
            if (currentNumber.length > 0) {
                try {
                    val num = Integer.parseInt(currentNumber)
                    numbers.add(num)
                } catch (e: NumberFormatException) {
                    // Skip invalid numbers
                }
                currentNumber = ""
            }
        } else {
            currentNumber += char
        }
        i++
    }
    
    // Add the last number
    if (currentNumber.length > 0) {
        try {
            val num = Integer.parseInt(currentNumber)
            numbers.add(num)
        } catch (e: NumberFormatException) {
            // Skip invalid numbers
        }
    }
    
    val reversed = reverseList(numbers)
    
    System.out.println("Original list: $numbers")
    System.out.println("Reversed list: $reversed")
}