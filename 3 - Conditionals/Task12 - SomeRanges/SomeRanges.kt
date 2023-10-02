fun main(args: Array<String>) {
	
	var isInRange = 1 in 1..3
	println("1 in 1..3 -> $isInRange")
	val rangeList = (1..3).toList()
	println("1..3 as a list: $rangeList")
	isInRange = 1 in 3 downTo 1
	println("1 in 3 downTo 1 -> $isInRange")
	isInRange = 1 in 1 until 3
	println("1 in 1 until 3 -> $isInRange")
	isInRange = 3 in 1 until 3
   	println("3 in 1 until 3 -> $isInRange")
	isInRange = 2 in 1..3
	println("2 in 1..3 -> $isInRange")
	isInRange = 2 !in 1..3
	println("2 !in 1..3 -> $isInRange")
	isInRange = 'x' in 'a'..'z'
	println("'x' in 'a'..'z' -> $isInRange")
}
