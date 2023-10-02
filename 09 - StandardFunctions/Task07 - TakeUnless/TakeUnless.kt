fun main(args: Array<String>) {
	val fileContents = File("myfile.txt").takeUnless { it.isHidden }?.readText()
}