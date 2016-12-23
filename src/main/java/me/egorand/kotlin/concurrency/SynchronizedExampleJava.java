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

package me.egorand.kotlin.concurrency;

public class SynchronizedExampleJava {

    public synchronized void synchronizedMethod() {
        System.out.println("inside a synchronized method: " + Thread.currentThread());
    }

    public void methodWithSynchronizedBlock() {
        System.out.println("outside of a synchronized block: " + Thread.currentThread());
        synchronized (this) {
            System.out.println("inside a synchronized block: " + Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        System.out.println("starting: " + Thread.currentThread());

        final SynchronizedExampleJava example = new SynchronizedExampleJava();

        new Thread(new Runnable() {
            @Override public void run() {
                example.synchronizedMethod();
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                example.methodWithSynchronizedBlock();
            }
        }).start();

        System.out.println("finishing: " + Thread.currentThread());
    }
}
