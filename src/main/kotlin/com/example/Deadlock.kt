@file:JvmName("Deadlock")

package com.example

val lockA = Any()
val lockB = Any()

class ThreadA : Thread() {

    override fun run() {

        synchronized(lockA) {

            println("ThreadA: holding lockA...")

            try {
                Thread.sleep(10)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("ThreadA: waiting lockB...")

            synchronized(lockB) {

                println("ThreadA: holding lock A & B...")
            }
        }
    }
}

class ThreadB : Thread() {

    override fun run() {

        synchronized(lockB) {

            println("ThreadB: holding lockB...")

            try {
                Thread.sleep(10)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("ThreadB: waiting lockA...")

            synchronized(lockA) {

                println("ThreadB: holding lock B & A...")
            }
        }
    }
}

fun main() {

    ThreadA().start()
    ThreadB().start()
}