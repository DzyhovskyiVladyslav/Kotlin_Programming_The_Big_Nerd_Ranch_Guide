import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
				.readText()
				.split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {
	(0..9).forEach {
		val first = patronList.shuffled().first()
		val last = lastName.shuffled().first()
		val name = "$first $last"
		uniquePatrons += name
	}
	uniquePatrons.forEach {
		patronGold[it] = 6.0
	}

	var orderCount = 0
	while (orderCount <= 9) {
		placeOrder(uniquePatrons.shuffled().first(),
		menuList.shuffled().first())
		orderCount++
	}
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

private fun placeOrder(patronName: String, menuData: String) {
	val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
	val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
	println("$patronName speaks with $tavernMaster about their order.")
	val (type, name, price) = menuData.split(',')
	val message = "$patronName buys a $name ($type) for $price."
	println(message)
	//performPurchase(price.toDouble())
	val phrase = if (name == "Dragon's Breath") {
		"$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
	} else {
		"$patronName says: Thanks for the $name."
	}
	println(phrase)
}