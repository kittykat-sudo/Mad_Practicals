class Employee(val name: String, val id: Int) {
    
    companion object {
        private var employeeCount = 0
        
        fun getEmployeeCount(): Int {
            return employeeCount
        }
        
        fun createEmployee(name: String, id: Int): Employee {
            employeeCount++
            return Employee(name, id)
        }
    }
    
    init {
        System.out.println("Employee created: $name (ID: $id)")
    }
}

fun main() {
    System.out.println("Initial employee count: ${Employee.getEmployeeCount()}")
    
    val emp1 = Employee.createEmployee("John Doe", 101)
    val emp2 = Employee.createEmployee("Jane Smith", 102)
    val emp3 = Employee.createEmployee("Bob Johnson", 103)
    
    System.out.println("Total employees created: ${Employee.getEmployeeCount()}")
}