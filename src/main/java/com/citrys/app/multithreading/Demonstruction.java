package com.citrys.app.multithreading;

public class Demonstruction {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hello"));
        ExecuteMe exec = new ExecuteMe();

        t.start();
        exec.start();
        exec.join();
    }
}


class ExecuteMe extends Thread {

    @Override
    public void run() {
        System.out.println("Executable");
    }
}