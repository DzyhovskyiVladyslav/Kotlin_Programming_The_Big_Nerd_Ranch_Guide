import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 100
var playerSilver = 30
var caskOfDragonsBreath = 5.0

fun main(args: Array<String>) {
	placeOrder("shandy,Dragon's Breath,5.91")
}

fun performPurchase(price: Double) {
	displayBalance()
	val totalPurse = playerGold + (playerSilver / 100.0)
	println("Total purse: $totalPurse")
	println("Purchasing item for $price")
	val remainingBalance = totalPurse - price
	println("Remaining balance: ${"%.2f".format(remainingBalance)}")
	val remainingGold = remainingBalance.toInt()
	val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
	caskOfDragonsBreath -= 0.125
	playerGold = remainingGold
	playerSilver = remainingSilver
	displayBalance()
}

private fun displayBalance() {
	println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
	phrase.replace(Regex("[aeiou]")) {
		when (it.value) {
		"a" -> "4"
		"e" -> "3"
		"i" -> "1"
		"o" -> "0"
		"u" -> "|_|"
		else -> it.value
	}
}

private fun placeOrder(menuData: String) {
	val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
	val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
	println("Madrigal speaks with $tavernMaster about their order.")
	val (type, name, price) = menuData.split(',')
	val message = "Madrigal buys a $name ($type) for $price."
	for(i in 1..10) {
		println(message)
		performPurchase(price.toDouble())
	}
	val phrase = if (name == "Dragon's Breath") {
		"Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
	} else {
		"Madrigal says: Thanks for the $name."
	}
	println(phrase)
	if (name == "Dragon's Breath")
		println("After your visit in cask of $name left ${"%.3f".format(caskOfDragonsBreath)} gallons")
}