import java.util.Scanner

fun getGrade(score: Int): String {
    return when {
        score >= 90 -> "A"
        score >= 80 -> "B"
        score >= 70 -> "C"
        score >= 60 -> "D"
        score >= 0 -> "F"
        else -> "Invalid Score"
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    
    System.out.print("Enter student score (0-100): ")
    val score = scanner.nextInt()
    
    val grade = getGrade(score)
    System.out.println("Score: $score")
    System.out.println("Grade: $grade")
    
    // Demonstrate with multiple scores
    val testScores = intArrayOf(95, 87, 76, 65, 45, 105, -5)
    System.out.println("\nTest scores and grades:")
    for (testScore in testScores) {
        System.out.println("Score: $testScore, Grade: ${getGrade(testScore)}")
    }
}