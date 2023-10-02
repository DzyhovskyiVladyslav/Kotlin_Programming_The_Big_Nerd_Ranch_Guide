fun main(args: Array<String>) {
	var healthPoints = 89
	var isBlessed = true
	val isImmortal = false
	val player = Player()
	player.name = "estragon "
	print(player.name + "TheBrave")
	val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
	val healthStatus = formatHealthStatus(healthPoints, isBlessed)

	printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)
	player.castFireball()
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String = 
	when (healthPoints) {
		100 -> "is in excellent condition!"
		in 90..99 -> "has a few scratches."
		in 75..89 -> if (isBlessed) {
			"has some minor wounds, but is healing quite quickly!"
		} else {
			"has some minor wounds."
		}
		in 15..74 -> "looks pretty hurt."
		else -> "is in awful condition!"
	}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String) {
	println("(Aura: $auraColor) " +
		"(Blessed: ${if (isBlessed) "YES" else "NO"})")
	println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
	val auraVisible = isBlessed && healthPoints > 50 || isImmortal
	val auraColor = if (auraVisible) "GREEN" else "NONE"
	return auraColor
}