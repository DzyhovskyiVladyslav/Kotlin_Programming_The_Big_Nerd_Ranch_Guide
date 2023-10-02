fun main(args: Array<String>) {
	var fileContents: List<String>
	File("file.txt")
		.also {
			print(it.name)
		}.also {
			fileContents = it.readLines()
		}
}
