class Dice() {
	val rolledValue
		get() = (1..6).shuffled().first()
}

fun main(args: Array<String>) {
	val myD6 = Dice()
	println(myD6.rolledValue)
	println(myD6.rolledValue)
	println(myD6.rolledValue)
}