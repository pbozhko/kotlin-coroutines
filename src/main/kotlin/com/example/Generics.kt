package com.example

interface Container<in T, out P> where T : kotlin.Number, P : Collection<*> {

    fun modify(t: T): P
}

class CustomContainer : Container<Int, List<String>> {

    override fun modify(t: Int): List<String> {

        test()
        return listOf(toString())
    }

    inline fun test() {

        println("inline")
    }
}

fun main() {

    println(CustomContainer().modify(5).javaClass)
}