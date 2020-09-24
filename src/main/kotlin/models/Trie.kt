package models

import java.util.*

private fun add(item: TrieItem, element: String) {
    if (element == item.value) item.quantityOfWords++

    var currentItem: TrieItem? = null
    val index = if (item.value == "") 0 else 1

    for (i in item.children) {
        if (i.value == element[index].toString()) {
            currentItem = i
            break
        }
    }

    if (currentItem == null) {
        currentItem = TrieItem(element[index].toString())
        item.children.add(currentItem)
    }

    add(currentItem, element.substring(index))
}

class TrieItem(val value: String) {
    val children: MutableList<TrieItem> = mutableListOf()
    var quantityOfWords = 0
}

class Trie {

    private val head: TrieItem = TrieItem("")

    fun add(element: String) {
        add(head, element)
    }

    fun getTop(quantity: Int): List<Pair<String, Int>> {
        val queue = LinkedList<TrieItem>()

        queue.add(head)

        val heap = WordsHeap()

        while (!queue.isEmpty()) {
            val item = queue.poll()

            if (heap.getSize() > 30) {

            }
        }
    }
}