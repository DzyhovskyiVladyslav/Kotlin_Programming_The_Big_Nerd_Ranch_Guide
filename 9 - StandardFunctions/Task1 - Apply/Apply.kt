fun main(args: Array<String>) {
	val menuFile = File("menu-file.txt").apply {
		setReadable(true) // Implicitly, menuFile.setReadable(true)
		setWritable(true) // Implicitly, menuFile.setWritable(true)
		setExecutable(false) // Implicitly, menuFile.setExecutable(false)
	}
}