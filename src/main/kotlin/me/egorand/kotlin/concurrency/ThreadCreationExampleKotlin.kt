package me.egorand.kotlin.concurrency

import kotlin.concurrent.thread

fun main(args: Array<String>) {
  println("starting: " + Thread.currentThread())

  // subclassing Thread to create a thread
  // Object expressions: https://kotlinlang.org/docs/reference/object-declarations.html#object-expressions
  object : Thread() {
    override fun run() {
      println("running from Thread: ${Thread.currentThread()}")
    }
  }.start()

  // passing a lambda expression to create a thread
  // Lambda expressions: https://kotlinlang.org/docs/reference/lambdas.html#lambda-expressions-and-anonymous-functions
  Thread({
    println("running from lambda: ${Thread.currentThread()}")
  }).start()

  // using thread() function to create a thread
  // thread: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/thread.html
  thread(start = true) {
    println("running from thread(): ${Thread.currentThread()}")
  }

  println("finishing: " + Thread.currentThread())
}