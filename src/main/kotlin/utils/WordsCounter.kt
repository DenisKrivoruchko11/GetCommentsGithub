package utils

import models.Trie

private fun getWords(data: MutableList<String>): Trie {
    val trie = Trie()

    data.forEach { it.split(" ").forEach { word -> trie.add(word) } }

    return trie
}

class WordsCounter {

    fun getWordsCount(data: MutableList<String>): List<Pair<String, Int>> {
        val trie = getWords(data)

        return trie.getTop(30)
    }
}