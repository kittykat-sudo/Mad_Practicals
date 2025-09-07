import java.util.Scanner

fun isPalindrome(input: String): Boolean {
    val length = input.length
    for (i in 0..length / 2) {
        if (input[i] != input[length - 1 - i]) {
            return false
        }
    }
    return true
}

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter a word to check whether it's a palindrome: ")
    val input = scanner.nextLine()
    
    if (isPalindrome(input)) {
        System.out.println("$input is a palindrome.")
    } else {
        System.out.println("$input is not a palindrome.")
    }
}