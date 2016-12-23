package me.egorand.kotlin.concurrency

import kotlin.concurrent.thread

class VolatileExampleKotlin {

  // @Volatile: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html
  @Volatile private var running = false

  fun start() {
    running = true
    thread(start = true) {
      while (running) {
        println("Still running: ${Thread.currentThread()}")
      }
    }
  }

  fun stop() {
    running = false
    println("Stopped: ${Thread.currentThread()}")
  }
}

fun main(args: Array<String>) {
  println("starting: " + Thread.currentThread())

  val example = VolatileExampleKotlin()

  example.start()

  Thread.sleep(100)

  example.stop()

  println("finishing: " + Thread.currentThread())
}