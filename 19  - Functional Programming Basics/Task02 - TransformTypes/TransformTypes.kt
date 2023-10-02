fun main(args: Array<String>) {
	val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
	val tenDollarWordLengths = tenDollarWords.map { it.length }
	print(tenDollarWordLengths)
}