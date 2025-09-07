import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter a username: ")
    
    try {
        val username = scanner.nextLine()
        if (username!=null) {
            System.out.println("Hello, $username!")
        } else {
            System.out.println("Invalid input. Please enter a valid username.")
        }
    } catch (e: Exception) {
        System.out.println("An error occurred.")
    }
}