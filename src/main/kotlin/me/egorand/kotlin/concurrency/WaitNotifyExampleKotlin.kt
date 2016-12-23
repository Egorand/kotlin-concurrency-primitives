package me.egorand.kotlin.concurrency

import java.util.*
import kotlin.concurrent.thread

class WaitNotifyExampleKotlin(private val maxItems: Int) {

  @Volatile private var items = 0
  private val rand = Random()

  private val lock = java.lang.Object()

  fun produce() = synchronized(lock) {
    while (items >= maxItems) {
      lock.wait()
    }
    Thread.sleep(rand.nextInt(100).toLong())
    items++
    println("Produced, count is $items: ${Thread.currentThread()}")
    lock.notifyAll()
  }

  fun consume() = synchronized(lock) {
    while (items <= 0) {
      lock.wait()
    }
    Thread.sleep(rand.nextInt(100).toLong())
    items--
    println("Consumed, count is $items: ${Thread.currentThread()}")
    lock.notifyAll()
  }
}

fun main(args: Array<String>) {
  println("starting: ${Thread.currentThread()}")

  val example = WaitNotifyExampleKotlin(5)

  for (i in 0..14) {
    thread(start = true) {
      if (i < 5) {
        example.consume()
      } else {
        example.produce()
      }
    }
  }

  Thread.sleep(1000)
  println("finishing: ${Thread.currentThread()}")
}