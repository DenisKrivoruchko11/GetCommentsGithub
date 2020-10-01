package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeapTests {

    @Test
    fun `tryToAdd should add item to empty heap`() {
        val heap = Heap<Int, Int>(5)

        heap.tryToAdd(HeapItem(3, 4))

        val expected = listOf(HeapItem(3, 4))
        val actual = mutableListOf<HeapItem<Int, Int>>()
        heap.forEach { actual.add(it) }

        assertIterableEquals(expected, actual)
    }

    @Test
    fun `tryToAdd should add some items when the number of items is less than the limit`() {
        val heap = Heap<Int, String>(1000)

        for (i in 100 until 200) heap.tryToAdd(HeapItem(i, "example$i"))
        for (i in 0 until 100) heap.tryToAdd(HeapItem(i, "example$i"))

        val result = List(200) { HeapItem(it, "example$it") }

        var i = 0
        heap.forEach {
            if (i == 0) assertEquals(it, result[0])

            assertTrue(result.contains(it))

            i++
        }
    }

    @Test
    fun `tryToAdd should add some items when the number of elements is greater than the limit`() {
        val heap = Heap<Int, String>(150)

        for (i in 0 until 150) heap.tryToAdd(HeapItem(i, "example$i"))

        val result = List(150) { HeapItem(it, "example$it") }

        var i = 0
        heap.forEach {
            if (i == 0) assertEquals(it, result[0])

            assertTrue(result.contains(it))

            i++
        }
    }

    @Test
    fun `tryToAdd should ignore the item with the min key when the number of elements is greater than the limit`() {
        val heap = Heap<Int, String>(150)

        for (i in 100 until 200) heap.tryToAdd(HeapItem(i, "example$i"))
        for (i in 0 until 100) heap.tryToAdd(HeapItem(i, "example$i"))

        val result1 = mutableListOf<HeapItem<Int, String>>()
        val result2 = mutableListOf<HeapItem<Int, String>>()

        heap.forEach { result1.add(it) }

        heap.tryToAdd(HeapItem(-1, "example"))
        heap.forEach { result2.add(it) }

        result2.forEachIndexed { index, it -> assertEquals(it, result1[index]) }
    }

    @Test
    fun `tryToAdd should ignore the item with the min key from heap when the number of elements is greater than the limit`() {
        val heap = Heap<Int, String>(150)

        for (i in 100 until 200) heap.tryToAdd(HeapItem(i, "example$i"))
        for (i in 0 until 100) heap.tryToAdd(HeapItem(i, "example$i"))

        val result1 = mutableListOf<HeapItem<Int, String>>()
        val result2 = mutableListOf<HeapItem<Int, String>>()

        heap.forEach { result1.add(it) }

        heap.tryToAdd(HeapItem(0, "example"))
        heap.forEach { result2.add(it) }

        result2.forEachIndexed { index, it -> assertEquals(it, result1[index]) }
    }
}
