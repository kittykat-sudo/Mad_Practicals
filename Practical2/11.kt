abstract class Animal {
    abstract fun makeSound()
}

class Dog : Animal() {
    override fun makeSound() {
        System.out.println("Woof! Woof!")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        System.out.println("Meow! Meow!")
    }
}

fun main() {
    val dog = Dog()
    val cat = Cat()
    
    System.out.println("Dog sound:")
    dog.makeSound()
    
    System.out.println("Cat sound:")
    cat.makeSound()
    
    // Polymorphism demonstration
    val animals = arrayOf<Animal>(Dog(), Cat(), Dog())
    System.out.println("\nAll animals making sounds:")
    for (animal in animals) {
        animal.makeSound()
    }
}