package me.egorand.kotlin.concurrency

import kotlin.concurrent.thread

class SynchronizedExampleKotlin {

  // @Synchronized: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-synchronized/
  @Synchronized fun synchronizedMethod() {
    println("inside a synchronized method: ${Thread.currentThread()}")
  }

  // synchronized: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/synchronized.html
  fun methodWithSynchronizedBlock() {
    println("outside of a synchronized block: ${Thread.currentThread()}")
    synchronized(this) {
      println("inside a synchronized block: ${Thread.currentThread()}")
    }
  }
}

fun main(args: Array<String>) {
  println("starting: " + Thread.currentThread())

  val example = SynchronizedExampleKotlin()

  thread(start = true) {
    example.synchronizedMethod()
  }

  thread(start = true) {
    example.methodWithSynchronizedBlock()
  }

  println("finishing: " + Thread.currentThread())
}