fun main(args: Array<String>) {
	val name = "Madrigal"
	var healthPoints = 89
	var isBlessed = true
	val isImmortal = false

	val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
	val healthStatus = formatHealthStatus(healthPoints, isBlessed)

	printPlayerStatus(auraColor, isBlessed, name, healthStatus)
	val inebriationStatus = playerInebriationStatus(castFireball(3)) 
	println("Inebriation Status: $inebriationStatus")
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

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String = 
	if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun castFireball(numFireballs: Int = 2): Int {
    val maxInebriation = 50
    val inebriation = numFireballs * 10

    return if (inebriation <= maxInebriation) {
        println("A glass of Fireball springs into existence. (x$numFireballs)")
        inebriation
    } else {
        println("You've had too much Fireball. You feel woozy.")
        maxInebriation
    }
}

private fun playerInebriationStatus(inebriation : Int): String =
	when (inebriation) {
		in 41..50 -> "..t0aSt3d"
		in 31..40 -> "stewed"
		in 21..30 -> "soused"
		in 11..20 -> "sloshed"
		in 1..10 -> "tipsy"
		else -> "unknown"
	}