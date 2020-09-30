package models

data class TrieItem(var quantity: Int, val value: String, val children: MutableList<TrieItem>)

private fun add(word: String, item: TrieItem) {
    if (word == item.value) {
        item.quantity++
        return
    }

    var cur: TrieItem? = null

    val index = if (item.value == "") 0 else 1

    for (i in item.children) {
        if (i.value == word[index].toString()) {
            cur = i
            break
        }
    }

    if (cur == null) {
        cur = TrieItem(0, word[index].toString(), mutableListOf())
        item.children.add(cur)
    }

    add(word.substring(index), cur)
}

private fun dfs(heap: Heap<Int, String>, prefix: String, item: TrieItem) {
    item.children.forEach { dfs(heap, "$prefix${item.value}", it) }

    if (item.quantity > 0) heap.tryToAdd(HeapItem(item.quantity, "$prefix${item.value}"))
}

class Trie {

    private val head = TrieItem(0, "", mutableListOf())

    fun add(word: String) {
        add(word, head)
    }

    fun getTop(wordsQuantity: Int): List<Pair<Int, String>> {
        val heap = Heap<Int, String>(wordsQuantity)

        dfs(heap, "", head)

        val result = mutableListOf<Pair<Int, String>>()
        heap.forEach { result.add(Pair(it.key, it.value)) }
        return result.sortedBy { it.first }.reversed()
    }
}
