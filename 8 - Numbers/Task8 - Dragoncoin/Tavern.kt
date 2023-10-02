import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerDragoncoin = 5.0
var currencyOfDragoncoinToGold = 1.43
var playerGold = 0
var playerSilver = 0
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

fun performPurchaseForDragoncoin(price: Double) {
	displayBalance()
	val convertedPurse = playerDragoncoin * currencyOfDragoncoinToGold
	println("Total purse: $convertedPurse")
	println("Purchasing item for $price")
	val remainingBalance = convertedPurse - price
	println("Remaining balance: ${"%.4f".format(remainingBalance)}")
	val remainingDragoncoin = remainingBalance / currencyOfDragoncoinToGold
	playerDragoncoin = remainingDragoncoin
	displayBalance()
}

private fun displayBalance() {
	println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver, Dragoncoins: ${"%.4f".format(playerDragoncoin)}")
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

private fun isEnoughMoney(price: Double) : Boolean {
	return playerGold + (playerSilver / 100.0) - price >= 0
}

private fun isEnoughDragoncoin(price: Double) : Boolean {
	return playerDragoncoin * currencyOfDragoncoinToGold - price >= 0
}

private fun placeOrder(menuData: String) {
	val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
	val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
	println("Madrigal speaks with $tavernMaster about their order.")
	val (type, name, price) = menuData.split(',')
	for(i in 1..10) {
		if(isEnoughMoney(price.toDouble())) {
			println("Madrigal buys a $name ($type) for $price.")
			performPurchase(price.toDouble())
		} else if(isEnoughDragoncoin(price.toDouble())) {
			println("Madrigal buys a $name ($type) for $price using Dragoncoins.")
			performPurchaseForDragoncoin(price.toDouble())
		} else {
			println("Madrigal doesn't have enough money to buy a $name ($type) for $price.")
			break
		}
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