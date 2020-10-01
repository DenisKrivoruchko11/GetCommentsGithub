package utils

import models.Trie

class WordsCounter {

    fun getWordsList(wordsQuantity: Int, commitsMessages: List<String>): List<Pair<Int, String>> {
        val trie = Trie()

        commitsMessages.forEach { it.trim().split(" ").forEach { word -> trie.add(word) } }

        return trie.getTop(wordsQuantity)
    }
}
