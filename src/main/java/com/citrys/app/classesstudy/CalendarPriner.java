package com.citrys.app.classesstudy;

class IntHolder {
    private int val;
    IntHolder(int val) {
        this.val = val;
    }
    int getVal(){
        return this.val;
    }}
public class CalendarPriner {
    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2021, 4, 1);
//
//        while (date.getMonthValue() == 4) {
//
//            System.out.printf("%3d ", date.getDayOfMonth());
//            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
//                System.out.println();
//            }
//            System.out.printf("%3s", date.getDayOfWeek());
//            date = date.plusDays(1);
//
//        }
//
        IntHolder test1 = new IntHolder(1);

        IntHolder test2 = new IntHolder(2);
        swap(test1, test2);
        System.out.println(test1.getVal());

    }

    private static void swap(IntHolder t1, IntHolder t2) {
        IntHolder temp = t1;
        t1 = t2;
        t2 = temp;
    }
}
