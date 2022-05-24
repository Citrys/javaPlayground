package com.citrys.app.interfacesstudy;

import com.citrys.app.utils.Printer;


public enum SingleTonePractice {
    INSTANCE("Initial class info");

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    private SingleTonePractice(String info) {
        this.info = info;
    }

    public SingleTonePractice getInstance() {
        return INSTANCE;
    }
}


class TestSingleTone {
    public static void main(String[] args) {
        SingleTonePractice test = SingleTonePractice.INSTANCE.getInstance();
        SingleTonePractice test2 = SingleTonePractice.INSTANCE.getInstance();
        Printer.print(test.getInfo());
        Printer.print(test2.getInfo());
        test2.setInfo("Something changed");
        Printer.print(test.getInfo());
        Printer.print(test2.getInfo());
    }
}