package models

class WordsHeapItem(val value: String, val quantity: Int) {
    var leftChild: WordsHeapItem? = null
    var rightChild: WordsHeapItem? = null
}

class WordsHeap(headValue: String) {
    var head = WordsHeapItem("", -1)

    fun getMinQuantity() {

    }

    fun getSize(): Int {

    }

    fun add() {

    }

    fun extractMin() {

    }
}
