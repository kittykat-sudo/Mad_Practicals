import java.util.Scanner

fun countVowels(input: String): Int {
    var count = 0
    
    for (i in 0..input.length - 1) {
        val char = input[i]
        if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u' ||
            char == 'A' || char == 'E' || char == 'I' || char == 'O' || char == 'U') {
            count++
        }
    }
    return count
}

fun main() {
    val scanner = Scanner(System.`in`)
    System.out.print("Enter a string: ")
    val input = scanner.nextLine()
    
    val vowelCount = countVowels(input)
    System.out.println("Number of vowels in '$input': $vowelCount")
}