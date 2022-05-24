package com.citrys.app.classesstudy;

import com.citrys.app.utils.Printer;

import java.util.Random;

public class Employer {
    private String name = "";
    private double salary;
    private static int lastId = 0;
    private int id;


    Employer(String name, Double salary) {
        this.name = name;
        this.salary = salary;
        lastId ++;
        id = lastId;
    }


    void raiseSalary(Employer this, double byPercent) {
        double raise = (this.salary * byPercent) / 100;
        this.salary += raise;
    }

    String getName(){
        return this.name;
    }


    int getId(){
        return id;
    }

    private void initIdGeneration(){
        Random generator = new Random();
        id = 1 + generator.nextInt(1_000_000);
    }
}

class Boss {
    private Random generator = new Random();
    void raiseRamdomly(Employer e) {
        double raise = 10 * generator.nextGaussian();
        e.raiseSalary(raise);
    }

    public void replaceWithZombie(Employer e) {
        e = new Employer("", 0.0);
    }
}


class SolutionTest extends Printer {
    public static void main(String[] args) {
        Employer testem1 = new Employer( "Dmitry",123.6);
        Employer testem2 = new Employer( "Mari",200.0);
        print(testem1.getId());
        print(testem2.getId());
    }
}