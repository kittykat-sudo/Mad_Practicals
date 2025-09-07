class EvenNumberIterator(private val start: Int, private val end: Int) {
    private var current: Int
    
    init {
        // Start from the first even number >= start
        current = if (start % 2 == 0) start else start + 1
    }
    
    fun hasNext(): Boolean {
        return current <= end
    }
    
    fun next(): Int {
        val value = current
        current += 2  // Move to next even number
        return value
    }
}

class EvenNumberRange(private val start: Int, private val end: Int) {
    fun iterator(): EvenNumberIterator {
        return EvenNumberIterator(start, end)
    }
}

fun main() {
    val evenRange = EvenNumberRange(1, 10)
    val iterator = evenRange.iterator()
    
    System.out.println("Even numbers from 1 to 10:")
    while (iterator.hasNext()) {
        val evenNumber = iterator.next()
        System.out.print("$evenNumber ")
    }
    System.out.println()
    
    // Demonstrate with different range
    val evenRange2 = EvenNumberRange(5, 20)
    val iterator2 = evenRange2.iterator()
    
    System.out.println("\nEven numbers from 5 to 20:")
    while (iterator2.hasNext()) {
        val evenNumber = iterator2.next()
        System.out.print("$evenNumber ")
    }
    System.out.println()
}