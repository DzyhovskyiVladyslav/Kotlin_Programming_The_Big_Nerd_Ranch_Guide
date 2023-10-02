fun main(args: Array<String>) {
	val menuFile = File("menu-file.txt")
	val servesDragonsBreath = menuFile.run { //servesDragonsBreath will be true or false
		readText().contains("Dragon's Breath")
	}

	fun nameIsLong(name: String) = name.length >= 20
	"Madrigal".run(::nameIsLong) // False
	"Polarcubis, Supreme Master of NyetHack".run(::nameIsLong) // True

	fun nameIsLong(name: String) = name.length >= 20
	fun playerCreateMessage(nameTooLong: Boolean): String {
		return if (nameTooLong) {
			"Name is too long. Please choose another name."
		} else {
			"Welcome, adventurer"
		}
	}
	"Polarcubis, Supreme Master of NyetHack" //println(playerCreateMessage(nameIsLong("Polarcubis, Supreme Master of NyetHack")))
		.run(::nameIsLong)
		.run(::playerCreateMessage)
		.run(::println)

	val status = run {
		if (healthPoints == 100) "perfect health" else "has injuries"
	}
}