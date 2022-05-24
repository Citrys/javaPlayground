package com.citrys.app.simplehashmap;

public class StoredItem <T> {
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    private int key;
    private T item;

    StoredItem(int key, T item) {
        this.key  = key;
        this.item = item;
    }
}
