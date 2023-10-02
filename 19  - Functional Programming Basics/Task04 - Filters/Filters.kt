fun main(args: Array<String>) {
	val itemsOfManyColors = listOf(listOf("red apple", "green apple", "blue apple"),
			listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana"))
	val redItems = itemsOfManyColors.flatMap { it.filter { it.contains("red") } }
	print(redItems)
}