fun main(args: Array<String>) {
	performCombat()
	performCombat("Ulrich")
	performCombat("Hildr", true)
}

fun performCombat() {
	println("You see nothing to fight!")
}

fun performCombat(enemyName: String) {
	println("You begin fighting $enemyName.")
}

fun performCombat(enemyName: String, isBlessed: Boolean) {
	if (isBlessed) {
		println("You begin fighting $enemyName. You are blessed with 2X damage!")
	} else {
		println("You begin fighting $enemyName.")
	}
}