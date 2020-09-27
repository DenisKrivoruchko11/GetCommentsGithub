import utils.WordsCounter
import utils.WordsGetter

private fun getWords(input: String, commitsQuantity: Int, wordsQuantity: Int): List<String> {
    val commitsMessages = WordsGetter(input).getCommitsData(commitsQuantity)

    return WordsCounter().getWordsList(wordsQuantity, commitsMessages)
}

fun main() {
    try {
        println("")
        val input = readLine() ?: throw KotlinNullPointerException("Input must be non-empty.")

        println("")
        val commitsQuantity = readLine()?.toIntOrNull() ?: throw KotlinNullPointerException("Input must be a number.")

        println("")
        val wordsQuantity = readLine()?.toIntOrNull() ?: throw KotlinNullPointerException("Input must be a number.")

        val result = getWords(input, commitsQuantity, wordsQuantity)
        result.forEach { println(it) }
    } catch (e: KotlinNullPointerException) {
        println(e.message)
    } finally {
        println("Program stopped.")
    }
}