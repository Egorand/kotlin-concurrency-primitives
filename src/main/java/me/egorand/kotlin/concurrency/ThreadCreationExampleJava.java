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

public class ThreadCreationExampleJava {

    public static void main(String[] args) {
        System.out.println("starting: " + Thread.currentThread());

        // subclassing Thread class to create a new thread
        new Thread() {
            @Override public void run() {
                System.out.println("running from Thread: " + Thread.currentThread());
            }
        }.start();

        // passing a Runnable to create a thread
        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("running from Runnable: " + Thread.currentThread());
            }
        }).start();

        System.out.println("finishing: " + Thread.currentThread());
    }
}
