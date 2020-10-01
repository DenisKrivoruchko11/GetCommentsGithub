package models

data class HeapItem<K, T>(val key: K, val value: T)

class Heap<K : Comparable<K>, T>(private val itemsQuantity: Int) : Iterable<HeapItem<K, T>> {

    private val items: MutableList<HeapItem<K, T>> = mutableListOf()

    private fun add(item: HeapItem<K, T>) {
        items.add(item)

        var currentIndex = items.lastIndex
        var parentIndex = (currentIndex - 1) / 2

        while (currentIndex > 0 && items[currentIndex].key < items[parentIndex].key) {
            val temp = items[currentIndex]
            items[currentIndex] = items[parentIndex]
            items[parentIndex] = temp

            currentIndex = parentIndex
            parentIndex = (currentIndex - 1) / 2
        }
    }

    private fun swapWithMin(item: HeapItem<K, T>) {
        items[0] = item

        var currentIndex = 0
        var leftIndex = 1
        var rightIndex = 2

        while (true) {
            var smallestIndex = currentIndex

            if (items.lastIndex >= leftIndex && items[smallestIndex].key > items[leftIndex].key) {
                smallestIndex = leftIndex
            }
            if (items.lastIndex >= rightIndex && items[smallestIndex].key > items[rightIndex].key) {
                smallestIndex = rightIndex
            }
            if (currentIndex == smallestIndex) break

            val temp = items[currentIndex]
            items[currentIndex] = items[smallestIndex]
            items[smallestIndex] = temp

            currentIndex = smallestIndex
            leftIndex = 2 * currentIndex + 1
            rightIndex = 2 * currentIndex + 2
        }
    }

    fun tryToAdd(item: HeapItem<K, T>) {
        if (items.size < itemsQuantity) add(item) else if (items[0].key < item.key) swapWithMin(item)
    }

    override fun iterator(): Iterator<HeapItem<K, T>> {
        return items.iterator()
    }
}
