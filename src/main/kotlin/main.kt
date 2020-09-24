import utils.WordsCounter
import utils.WordsGetter

private fun getWords(): List<Pair<String, Int>> {
    val data = WordsGetter().getWords()

    return WordsCounter().getWordsCount(data)
}

fun main() {
    println("Most popular words:")

    getWords().forEach { println("${it.first}: ${it.second}") }
}