val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)

fun main(args: Array<String>) {
    val step1Result = valuesToAdd.filter { it >= 5 }
    println("Step 1: $step1Result")
    val step2Result = step1Result.chunked(2)
    println("Step 2: $step2Result")
    val step3Result = step2Result.map { it.reduce { acc, num -> acc * num } }
    println("Step 3: $step3Result")
    val finalResult = step3Result.sum()
    println("Step 4: $finalResult")
}