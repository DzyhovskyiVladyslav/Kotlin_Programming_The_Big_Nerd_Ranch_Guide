fun main(args: Array<String>) {
	val name = "Madrigal"
	var healthPoints = 89
	val isBlessed = true
	val isImmortal = false
	val auraVisible = isBlessed && healthPoints > 50 || isImmortal
	val auraColor = if (auraVisible) "GREEN" else "NONE"

	println(auraColor)
}
