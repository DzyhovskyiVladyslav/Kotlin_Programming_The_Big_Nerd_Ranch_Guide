fun main(args: Array<String>) {
	val name = "Madrigal"
	var healthPoints = 89
	val isBlessed = true
	val isImmortal = false

	if (isBlessed && healthPoints > 50 || isImmortal) {
		println("GREEN")
	} else {
		println("NONE")
	}
	if (healthPoints == 100) {
		println(name + " is in excellent condition!")
	} else {
		println(name + " is in awful condition!")
	}
}
