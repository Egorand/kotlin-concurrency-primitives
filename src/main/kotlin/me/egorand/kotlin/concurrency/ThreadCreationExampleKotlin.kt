/*
 * Copyright 2016 Egor Andreevici
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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