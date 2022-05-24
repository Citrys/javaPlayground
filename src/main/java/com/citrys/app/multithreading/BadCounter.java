package com.citrys.app.multithreading;
import java.util.Random;

class DemoThreadUnsafe {

    // We'll use this to randomly sleep our threads
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        // create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // setup thread1 to increment the badCounter 200 times
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.increment();
                DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
            }
        });

        // setup thread2 to decrement the badCounter 200 times
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.decrement();
                DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
            }
        });

        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();
    }

    private static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException ignored) {
        }
    }
}

class ThreadUnsafeCounter {

    private int count = 0;

    void increment() {
        count++;
    }

    void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}
