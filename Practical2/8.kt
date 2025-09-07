import java.util.Scanner

fun factorial(n: Int): Long {
    if (n < 0) return -1 // Error case
    
    var result: Long = 1
    var i = 1
    
    while (i <= n) {
        result *= i
        i++
    }
    return result
}

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter a number to calculate factorial: ")
    val number = scanner.nextInt()
    
    val result = factorial(number)
    if (result == -1L) {
        System.out.println("Factorial is not defined for negative numbers.")
    } else {
        System.out.println("Factorial of $number is: $result")
    }
}