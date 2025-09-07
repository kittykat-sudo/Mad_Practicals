// Since sealed classes may not work, we'll use abstract class with inheritance
abstract class Shape {
    abstract fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun calculateArea(): Double {
        return 3.14159 * radius * radius
    }
    
    override fun toString(): String {
        return "Circle(radius=$radius)"
    }
}

class Square(private val side: Double) : Shape() {
    override fun calculateArea(): Double {
        return side * side
    }
    
    override fun toString(): String {
        return "Square(side=$side)"
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
    
    override fun toString(): String {
        return "Rectangle(width=$width, height=$height)"
    }
}

fun calculateArea(shape: Shape): Double {
    return shape.calculateArea()
}

fun main() {
    val shapes = arrayOf<Shape>(
        Circle(5.0),
        Square(4.0),
        Rectangle(3.0, 6.0)
    )
    
    for (shape in shapes) {
        val area = calculateArea(shape)
        System.out.println("$shape -> Area: $area")
    }
}