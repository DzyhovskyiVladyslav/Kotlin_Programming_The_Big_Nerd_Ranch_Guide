fun main(args: Array<String>) {
	val employees = listOf("Denny", "Claudette", "Peter")
	val shirtSize = listOf("large", "x-large", "medium")
	val employeeShirtSizes = employees.zip(shirtSize).toMap()
	println(employeeShirtSizes["Denny"])
}