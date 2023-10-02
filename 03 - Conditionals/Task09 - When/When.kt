fun main(args: Array<String>) {
	val race = "gnome"
	val faction = when (race) {
		"dwarf" -> "Keepers of the Mines"
		"gnome" -> "Keepers of the Mines"
		"orc" -> "Free People of the Rolling Hills"
		"human" -> "Free People of the Rolling Hills"
		else -> "Unknown Race"
	}

	println(faction)
}
