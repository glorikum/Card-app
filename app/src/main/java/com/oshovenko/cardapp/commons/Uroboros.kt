package com.oshovenko.cardapp.commons

class Uroboros(private val list: ArrayList<String>, current: String) {

    private var currentIndex: Int

    init {
        currentIndex = list.indexOf(current)
    }

    fun get() = list[currentIndex]

    fun prev(): Uroboros {
        currentIndex--
        if (currentIndex < 0) {
            currentIndex = list.size - 1
        }
        return this
    }

    fun next(): Uroboros {
        currentIndex++
        if (currentIndex > list.size - 1) {
            currentIndex = 0
        }
        return this
    }
}