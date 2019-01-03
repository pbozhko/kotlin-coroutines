package com.example

import kotlinx.coroutines.*

//fun main(args: Array<String>) {
//    GlobalScope.launch { // launch new coroutine in background and continue
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
//    }
//    println("Hello,") // main thread continues while coroutine is delayed
//    runBlocking {
//        delay(2000L)
//    }
//}

//fun main() = runBlocking {
//    GlobalScope.launch { // launch new coroutine in background and continue
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
//    }
//    println("Hello,") // main thread continues while coroutine is delayed
//    delay(2000L)
//}

//fun main() = runBlocking {
//    val job = GlobalScope.launch { // launch new coroutine in background and continue
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
//    }
//    println("Hello,") // main thread continues while coroutine is delayed
//    job.join()
//    delay(1000L)
//    println("Test")
//}

//fun main() = runBlocking {
//    launch {
//        delay(50L)
//        println("Task from runBlocking!")
//    }
//
//    coroutineScope {
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope")
//    }
//
//    println("Coroutine scope is over")
//}

//fun main() = runBlocking {
//    repeat(100_000) { i ->
//        launch {
//            doWorld(i)
//            println("Executed")
//        }
//    }
////    println("Test")
//}
//
//suspend fun doWorld(i: Int) {
//    delay(2000L)
//    println("$i")
//}

fun main() = runBlocking {
    val job = launch {
        val child = launch {
            try {
                println("I'm a child")
                delay(Long.MAX_VALUE)
            } finally {
                println("Child is cancelled")
            }
        }
        yield()
        println("Cancelling child")
        child.cancel()
        child.join()
        yield()
        println("Parent is not cancelled")
    }

    job.join()
}