fun main(args: Array<String>) {
	val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
	val primes = numbers.filter { number ->
			(2 until number).map { number % it }
			.none { it == 0 }
	}
	print(primes)
}