import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter an integer: ")
    
    try {
        val number = scanner.nextLong()
        if (number % 2L == 0L) {
            System.out.println("$number is even")
        } else {
            System.out.println("$number is odd")
        }
    } catch (e: Exception) {
        System.out.println("Invalid input. Please enter a valid integer.")
    }
}