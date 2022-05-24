package com.citrys.app.interfacesstudy;

public interface Closable {
    void close();
}

interface Channel extends Closable {

    boolean isOpen();

}


class FileSeq implements Channel, IntSequence {
    private int numberOfFiles;

    FileSeq(int numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

    @Override
    public void close() {
        numberOfFiles = 0;
    }

    @Override
    public boolean hasNext() {
        return numberOfFiles > 0;
    }

    @Override
    public int next() {
        numberOfFiles --;
        return numberOfFiles;
    }

    @Override
    public boolean isOpen() {
        return numberOfFiles > 0;
    }
}