import utils.WordsCounter
import utils.WordsGetter
import java.io.FileNotFoundException

private fun getWords(url: String, commitsQuantity: Int, wordsQuantity: Int): List<Pair<Int, String>> {
    val commitsMessages = WordsGetter(url).getCommitsData(commitsQuantity)

    return WordsCounter().getWordsList(wordsQuantity, commitsMessages)
}

private fun getInputData(): String {
    return readLine() ?: throw KotlinNullPointerException("Input must be non-empty.")
}

private fun getQuantity(): Int {
    val input = readLine()?.toIntOrNull() ?: throw ArithmeticException("Input must be a digit.")

    return if (input < 0) throw ArithmeticException("Input must be a positive digit.") else input
}

fun main() {
    try {
        println("Type path to repo (Format: repositoryOwner/repositoryName)")
        val url = "https://api.github.com/repos/${getInputData()}/"

        println("Type commits quantity")
        val commitsQuantity = getQuantity()

        println("Type words quantity")
        val wordsQuantity = getQuantity()

        val result = getWords(url, commitsQuantity, wordsQuantity)
        result.forEach { println("${it.second}${it.first}") }
    } catch (e: KotlinNullPointerException) {
        println(e.message)
    } catch (e: ArithmeticException) {
        println(e.message)
    } catch (e: FileNotFoundException) {
        println("Repository with this data does not exist.")
    } finally {
        println("Program stopped.")
    }
}
