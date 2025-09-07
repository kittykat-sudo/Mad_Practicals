import java.util.HashMap
import java.util.ArrayList

fun namesToLengthMap(names: ArrayList<String>): HashMap<String, Int> {
    val result = HashMap<String, Int>()
    var i = 0
    while (i < names.size) {
        val name = names[i]
        result.put(name, name.length)
        i++
    }
    return result
}

fun main() {
    val names = ArrayList<String>()
    names.add("Alice")
    names.add("Bob")
    names.add("Charlie")
    names.add("Diana")
    
    val nameMap = namesToLengthMap(names)
    
    System.out.println("Name to length mapping:")
    for (entry in nameMap.entries) {
        System.out.println("${entry.key} -> ${entry.value}")
    }
}