import java.util.ArrayList

fun filterEvenNumbers(numbers: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    var i = 0
    while (i < numbers.size) {
        val number = numbers[i]
        if (number % 2 == 0) {
            result.add(number)
        }
        i++
    }
    return result
}

fun filterOddNumbers(numbers: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    var i = 0
    while (i < numbers.size) {
        val number = numbers[i]
        if (number % 2 != 0) {
            result.add(number)
        }
        i++
    }
    return result
}

fun main() {
    val numbers = ArrayList<Int>()
    numbers.add(1)
    numbers.add(2)
    numbers.add(3)
    numbers.add(4)
    numbers.add(5)
    numbers.add(6)
    numbers.add(7)
    numbers.add(8)
    numbers.add(9)
    numbers.add(10)
    
    val evenNumbers = filterEvenNumbers(numbers)
    val oddNumbers = filterOddNumbers(numbers)
    
    System.out.println("Original list: $numbers")
    System.out.println("Even numbers: $evenNumbers")
    System.out.println("Odd numbers: $oddNumbers")
}