class LootBox<T : Loot>(vararg item: T) {
	var open = false
	private var loot: Array<out T> = item

	operator fun get(index: Int): T? = loot[index].takeIf { open }

	fun fetch(item: Int): T? {
		return loot[item].takeIf { open }
	}

	fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
		return lootModFunction(loot[item]).takeIf { open }
	}
}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)