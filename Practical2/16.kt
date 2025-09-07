import java.util.ArrayList

interface Comparator {
    fun compare(a: Int, b: Int): Boolean
}

fun findMax(numbers: ArrayList<Int>, comparator: Comparator): Int? {
    if (numbers.size == 0) return null
    
    var max = numbers[0]
    var i = 1
    while (i < numbers.size) {
        if (comparator.compare(numbers[i], max)) {
            max = numbers[i]
        }
        i++
    }
    return max
}

class StandardComparator : Comparator {
    override fun compare(a: Int, b: Int): Boolean {
        return a > b
    }
}

class AbsoluteValueComparator : Comparator {
    override fun compare(a: Int, b: Int): Boolean {
        val absA = if (a < 0) -a else a
        val absB = if (b < 0) -b else b
        return absA > absB
    }
}

fun main() {
    val numbers = ArrayList<Int>()
    numbers.add(1)
    numbers.add(3)
    numbers.add(7)
    numbers.add(2)
    numbers.add(5)
    
    // Standard comparison
    val standardComparator = StandardComparator()
    val max = findMax(numbers, standardComparator)
    
    System.out.println("Numbers: $numbers")
    System.out.println("Maximum value: $max")
    
    // Test with negative numbers using absolute value comparison
    val numbersWithNegative = ArrayList<Int>()
    numbersWithNegative.add(-10)
    numbersWithNegative.add(3)
    numbersWithNegative.add(7)
    numbersWithNegative.add(-15)
    numbersWithNegative.add(5)
    
    val absComparator = AbsoluteValueComparator()
    val maxAbs = findMax(numbersWithNegative, absComparator)
    
    System.out.println("\nNumbers with negatives: $numbersWithNegative")
    System.out.println("Maximum by absolute value: $maxAbs")
}