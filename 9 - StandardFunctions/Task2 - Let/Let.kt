fun main(args: Array<String>) {
	//val firstElement = listOf(1,2,3).first()
	//val firstItemSquared = firstElement * firstElement

	val firstItemSquared = listOf(1,2,3).first().let {
		it * it
	}
}

/*fun formatGreeting(vipGuest: String?): String {
	return if (vipGuest != null) {
		"Welcome, $vipGuest. Please, go straight back - your table is ready."
	} else {
		"Welcome to the tavern. You'll be seated shortly."
	}
}*/

fun formatGreeting(vipGuest: String?): String {
	return vipGuest?.let {
		"Welcome, $it. Please, go straight back - your table is ready."
	} ?: "Welcome to the tavern. You'll be seated soon."
}
