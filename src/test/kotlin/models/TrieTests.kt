package models

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

private fun generateTrie(): Pair<Trie, List<Pair<Int, String>>> {
    val trie = Trie()

    for (i in 0 until 3) trie.add("example${i % 2}")
    for (i in 0 until 3) trie.add("Wor")
    for (i in 0 until 9) trie.add("Word${i % 2}")
    for (i in 0 until 12) trie.add("World${i % 2}")

    val result = listOf(
        Pair(6, "World1"),
        Pair(6, "World0"),
        Pair(5, "Word0"),
        Pair(4, "Word1"),
        Pair(3, "Wor"),
        Pair(2, "example0"),
        Pair(1, "example1")
    )

    return Pair(trie, result)
}

class TrieTests {

    @Test
    fun `add should add word when trie is empty`() {
        val trie = Trie()

        trie.add("example")

        assertIterableEquals(listOf(Pair(1, "example")), trie.getTop(1))
    }

    @Test
    fun `add should add some words correctly`() {
        val generated = generateTrie()

        assertIterableEquals(generated.second, generated.first.getTop(10))
    }

    @Test
    fun `getTop should works correctly when trie is empty`() {
        val trie = Trie()

        assertIterableEquals(listOf<Pair<Int, String>>(), trie.getTop(100))
    }

    @Test
    fun `getTop should works correctly when trie contains more items than needed`() {
        val generated = generateTrie()

        assertIterableEquals(generated.second.subList(0, 3), generated.first.getTop(3))
    }

    @Test
    fun `getTop should works correctly when trie contains less items than needed`() {
        val generated = generateTrie()

        assertIterableEquals(generated.second, generated.first.getTop(100))
    }

    @Test
    fun `getTop should works correctly when trie contains as much items as needed`() {
        val generated = generateTrie()

        assertIterableEquals(generated.second, generated.first.getTop(7))
    }
}
