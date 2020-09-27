package utils

import models.Heap
import models.HeapItem
import models.Trie

class WordsCounter {

    fun getWordsList(wordsQuantity: Int, commitsMessages: List<String>): List<String> {
        val heap = Heap<Int, String>(wordsQuantity)
        val trie = Trie()

        commitsMessages.forEach { it.trim().split(" ").forEach { word -> trie.add(word) } }
        trie.forEach { heap.tryToAdd(HeapItem(it.first, it.second)) }

        val result = mutableListOf<String>()
        heap.forEach { result.add("${it.value}: ${it.key}") }
        return result
    }
}
