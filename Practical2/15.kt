class PersonDelegate {
    private var _name: String = ""
    private var _age: Int = 0
    
    fun getName(): String = _name
    fun setName(value: String) { _name = value }
    
    fun getAge(): Int = _age
    fun setAge(value: Int) { _age = value }
}

class Person {
    private val delegate = PersonDelegate()
    
    var name: String
        get() = delegate.getName()
        set(value) = delegate.setName(value)
    
    var age: Int
        get() = delegate.getAge()
        set(value) = delegate.setAge(value)
    
    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun main() {
    val person = Person()
    person.name = "John Doe"
    person.age = 30
    
    System.out.println("Person details: $person")
    System.out.println("Name: ${person.name}")
    System.out.println("Age: ${person.age}")
}