package com.citrys.app.multithreading;

import java.util.*;

class Demonstration {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Run test");
        RaceCondition.runTest();
    }
}

class RaceCondition {

    private int randInt;
    private Random random = new Random(System.currentTimeMillis());

    private void printer() {

        int i = 1000000;
        while (i != 0) {
            {
                if (randInt % 5 == 0) {
                    if (randInt % 5 != 0)
                        System.out.println(randInt);
                }
            }
            i--;
        }
    }

    private void modifier() {

        int i = 1000000;
        while (i != 0) {
            {
                randInt = random.nextInt(1000);
                i--;
            }
        }
    }

    static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(rc::printer);
        Thread thread2 = new Thread(rc::modifier);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}