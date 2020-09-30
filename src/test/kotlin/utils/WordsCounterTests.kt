package utils

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

class WordsCounterTests {

    @Test
    fun `getWordsList should works correctly when commitsMessages is empty`() {
        val counter = WordsCounter()

        assertIterableEquals(listOf<Pair<Int, String>>(), counter.getWordsList(100, listOf()))
    }

    @Test
    fun `getWordsList should works correctly when commitsMessages contains more words than needed`() {
        val counter = WordsCounter()

        val messages1 = MutableList(90) { "example1" }
        val messages2 = MutableList(60) { "example2" }
        val messages3 = MutableList(30) { "example3" }

        val messages = mutableListOf<String>()
        messages.addAll(messages1)
        messages.addAll(messages2)
        messages.addAll(messages3)

        val result = listOf(Pair(90, "example1"), Pair(60, "example2"))

        assertIterableEquals(result, counter.getWordsList(2, messages))
    }

    @Test
    fun `getWordsList should works correctly commitsMessages trie contains less words than needed`() {
        val counter = WordsCounter()

        val messages1 = MutableList(90) { "example1" }
        val messages2 = MutableList(60) { "example2" }
        val messages3 = MutableList(30) { "example3" }

        val messages = mutableListOf<String>()
        messages.addAll(messages1)
        messages.addAll(messages2)
        messages.addAll(messages3)

        val result = listOf(Pair(90, "example1"), Pair(60, "example2"), Pair(30, "example3"))

        assertIterableEquals(result, counter.getWordsList(100, messages))
    }

    @Test
    fun `getWordsList should works correctly commitsMessages trie contains as much words as needed`() {
        val counter = WordsCounter()

        val messages1 = MutableList(90) { "example1" }
        val messages2 = MutableList(60) { "example2" }
        val messages3 = MutableList(30) { "example3" }

        val messages = mutableListOf<String>()
        messages.addAll(messages1)
        messages.addAll(messages2)
        messages.addAll(messages3)

        val result = listOf(Pair(90, "example1"), Pair(60, "example2"), Pair(30, "example3"))

        assertIterableEquals(result, counter.getWordsList(3, messages))
    }
}
