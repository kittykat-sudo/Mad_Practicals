data class Book(val title: String, val author: String, val price: Double)

fun main() {
    // Create instances
    val book1 = Book("1984", "George Orwell", 15.99)
    val book2 = Book("To Kill a Mockingbird", "Harper Lee", 12.50)
    
    // Print properties
    System.out.println("Book 1:")
    System.out.println("Title: ${book1.title}")
    System.out.println("Author: ${book1.author}")
    System.out.println("Price: $${book1.price}")
    
    System.out.println("\nBook 2: $book2")
    
    // Demonstrate data class features
    val book3 = book1.copy(price = 18.99)
    System.out.println("\nCopied book with new price: $book3")
}