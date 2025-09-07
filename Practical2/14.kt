import java.util.ArrayList
import java.util.Comparator

class DescendingComparator : Comparator<Int> {
    override fun compare(a: Int, b: Int): Int {
        return b - a // Reverse order for descending
    }
}

fun sortDescending(numbers: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    for (num in numbers) {
        result.add(num)
    }
    
    // Manual bubble sort implementation using while loops
    val size = result.size
    var i = 0
    while (i < size - 1) {
        var j = 0
        while (j < size - i - 1) {
            if (result[j] < result[j + 1]) {
                val temp = result[j]
                result[j] = result[j + 1]
                result[j + 1] = temp
            }
            j++
        }
        i++
    }
    return result
}

fun main() {
    val numbers = ArrayList<Int>()
    numbers.add(5)
    numbers.add(2)
    numbers.add(8)
    numbers.add(1)
    numbers.add(9)
    numbers.add(3)
    
    System.out.println("Original list: $numbers")
    
    val sorted = sortDescending(numbers)
    System.out.println("Sorted in descending order: $sorted")
}