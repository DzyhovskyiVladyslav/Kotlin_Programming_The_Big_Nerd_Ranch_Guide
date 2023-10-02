fun main(args: Array<String>) {
	val numLetters = "Mississippi".count({ letter ->
		letter == 's'
	})
	print(numLetters)
}