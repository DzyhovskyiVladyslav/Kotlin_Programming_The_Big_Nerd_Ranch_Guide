class LootBox<T : Loot>(item: T) {
	var open = false
	private var loot: T = item

	fun fetch(): T? {
		return loot.takeIf { open }
	}

	fun <R> fetch(lootModFunction: (T) -> R): R? {
		return lootModFunction(loot).takeIf { open }
	}
}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)

fun main(args: Array<String>) {
	val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
	val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

	lootBoxOne.open = true
	lootBoxOne.fetch()?.run {
		println("You retrieve $name from the box!")
	}

	val coin = lootBoxOne.fetch() {
		Coin(it.value * 3)
	}
	coin?.let { 
		println(it.value) 
	}
}