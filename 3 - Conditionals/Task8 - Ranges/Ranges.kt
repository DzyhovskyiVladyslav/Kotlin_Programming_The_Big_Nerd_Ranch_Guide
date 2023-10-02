fun main(args: Array<String>) {
	val name = "Madrigal"
	var healthPoints = 89
	val isBlessed = true
	val isImmortal = false
	val healthStatus = if (healthPoints == 100) {
		"is in excellent condition!"
	} else if (healthPoints in 90..99) {
		"has a few scratches."
	} else if (healthPoints in 75..89) {
		if (isBlessed) {
			"has some minor wounds but is healing quite quickly!"
		} else {
			"has some minor wounds."
		}
	} else if (healthPoints in 15..74) {
		"looks pretty hurt."
	} else {
		"is in awful condition!"
	}

	println(healthStatus)
}
