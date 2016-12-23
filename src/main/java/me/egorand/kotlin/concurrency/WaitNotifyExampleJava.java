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

import java.util.Random;

public class WaitNotifyExampleJava {

    private volatile int items;
    private final int maxItems;

    private final Random rand;

    public WaitNotifyExampleJava(int maxItems) {
        this.maxItems = maxItems;
        this.rand = new Random();
    }

    public synchronized void produce() {
        try {
            while (items >= maxItems) {
                wait();
            }
            Thread.sleep(rand.nextInt(100));
            items++;
            System.out.println("Produced, count is " + items + ": " + Thread.currentThread());
            notifyAll();
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public synchronized void consume() {
        try {
            while (items <= 0) {
                wait();
            }
            Thread.sleep(rand.nextInt(100));
            items--;
            System.out.println("Consumed, count is " + items + ": " + Thread.currentThread());
            notifyAll();
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("starting: " + Thread.currentThread());

        final WaitNotifyExampleJava example = new WaitNotifyExampleJava(5);

        for (int i = 0; i < 15; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override public void run() {
                    if (index < 5) {
                        example.consume();
                    } else {
                        example.produce();
                    }
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println("finishing: " + Thread.currentThread());
    }
}
