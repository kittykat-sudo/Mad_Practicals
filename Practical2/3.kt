import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter a number: ")
    val number = scanner.nextInt()
    System.out.println("Multiplication table for $number completed.")
    for (i in 1..10) {
        val result = number * i
        System.out.println("$number x $i = $result")
    }   
    
}