package models

data class HeapItem<K, T>(val key: K, val value: T)

class Heap<K : Comparable<K>, T>(private val itemsQuantity: Int) : Iterable<HeapItem<K, T>> {

    private val items: MutableList<HeapItem<K, T>> = mutableListOf()

    fun tryToAdd(item: HeapItem<K, T>) {

    }

    override fun iterator(): Iterator<HeapItem<K, T>> {
        TODO("Not yet implemented")
    }
}
