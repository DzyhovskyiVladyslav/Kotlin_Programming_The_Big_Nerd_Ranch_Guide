fun main(args: Array<String>) {
/*	val file = File("myfile.txt")
	val fileContents = if (file.canRead() && file.canWrite()) {
		file.readText()
	} else {
		null
	}*/

	val fileContents = File("myfile.txt")
		.takeIf { it.canRead() && it.canWrite() }
		?.readText()*
}