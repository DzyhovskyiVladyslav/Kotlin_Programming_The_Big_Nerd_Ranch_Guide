fun main(args: Array<String>) {
	val name = "Madrigal"
	var healthPoints = 70
	val isBlessed = true
	val isImmortal = false
	val auraVisible = isBlessed && healthPoints > 50 || isImmortal
	val karma = if (auraVisible) (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20 ).toInt() else -1;
	val auraColor = when (karma) {
		in 16..20 -> "GREEN"
		in 11..15 -> "PURPLE"
		in 6..10 -> "ORANGE"
		in 0..5 -> "RED"
		else -> "NONE"
	}
	val healthStatus = when (healthPoints) {
		100 -> "is in excellent condition!"
		in 90..99 -> "has a few scratches."
		in 75..89 -> if (isBlessed) {
			"has some minor wounds but is healing quite quickly!"
		} else {
			"has some minor wounds."
		}
		in 15..74 -> "looks pretty hurt."
		else -> "is in awful condition!"
	}

	val statusFormatString = "(HP)(A) -> H"
	val formattedStatusDisplay = statusFormatString
        .replace("(HP)", "(HP: $healthPoints)")
        .replace("(A)", "(Aura: $auraColor)")
        .replace(" H", " $name $healthStatus")
        .replace("(B)", "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println(formattedStatusDisplay)
}