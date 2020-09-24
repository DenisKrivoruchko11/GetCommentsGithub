package models

import java.util.*

class CommitsHeapItem(val value: String, val date: Date) {
    var leftChild: CommitsHeapItem? = null
    var rightChild: CommitsHeapItem? = null
}

class CommitsHeap(headValue: String) {
    var head = CommitsHeapItem("", Date())

    fun getMinDate(): Date {

    }

    fun getSize(): Int {

    }

    fun add(message: String, date: Date) {

    }

    fun extractMin() {

    }
}