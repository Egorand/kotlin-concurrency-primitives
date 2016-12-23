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