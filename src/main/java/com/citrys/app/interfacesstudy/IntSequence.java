package com.citrys.app.interfacesstudy;

interface IntSequence {
    default boolean hasNext() {return true;};

    int next();

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(value = "_ -> new", pure = true)

    static IntSequence digitsOf(int n) {

        return new SomeDigit(n);

    }
}


class SquareSeq implements IntSequence {
    private int i;
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int next() {
        i++;

        return i * i;
    }
}

class SomeDigit implements IntSequence {
    private int number;
    SomeDigit(int n) {
        this.number = n;
    }
    @Override
    public boolean hasNext() {
        return number != 0;
    }

    @Override
    public int next() {
        int result = number % 10;
        number /= 10;
        return result;
    }

    public int rest(){
        return number;
    }
}


class TestSeq {

    public static double average(IntSequence seq, int n) {
        int count = 0;
        double sum = 0;
        while (seq.hasNext() && count < n) {
            count++;
            sum += seq.next();
        }
        return count == 0 ? 0 : sum / count;
    }

    public static void main(String[] args) {
        IntSequence sq = new SquareSeq();

        IntSequence sd = new SomeDigit(1729);

        FileSeq file = new FileSeq(45);

        if (sd instanceof IntSequence) {
            System.out.println("Instance of digit");
        } else {
            System.out.println("not of digit");
        }

        IntSequence digits = IntSequence.digitsOf(1729);

        double ans = average(sq, 10);
        double ans2 = average(sd, 100);
        double ans3 = average(file, 46);
        System.out.println(ans);
        System.out.println(ans2);
    }
}