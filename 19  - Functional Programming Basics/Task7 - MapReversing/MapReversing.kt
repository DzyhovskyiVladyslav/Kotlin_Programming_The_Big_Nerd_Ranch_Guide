fun main(args: Array<String>) {
	val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
	print(flipValues(gradesByStudent))
}

fun <K, V> flipValues(map: Map<K, V>): Map<V, K> = 
		map.entries.associate { (key, value) -> value to key }