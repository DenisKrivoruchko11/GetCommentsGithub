package models

data class TrieItem(var quantity: Int, val value: String, val children: MutableList<TrieItem>)

class Trie : Iterable<Pair<Int, String>> {
    private val head = TrieItem(0, "", mutableListOf())

    fun add(word: String): Int {
        TODO()
    }

    override fun iterator(): Iterator<Pair<Int, String>> {
        TODO("Not yet implemented")
    }
}
