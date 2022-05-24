package com.citrys.app.linkedLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MyLinkedNode<T>{
    T value = null;
    MyLinkedNode<T> next = null;
    MyLinkedNode(T val, MyLinkedNode<T> next) {
        this.value = val;
        this.next = next;
    }
    MyLinkedNode(T val) {
        this.value = val;
    }
    MyLinkedNode() {
    }
}

class MySinglyLinkedList<T extends Comparable<T>> {
    private MyLinkedNode<T> head = new MyLinkedNode<>();

    void addToTheTail(T val) {
        if (head.value == null) {
            head.value = val;
        } else {
            MyLinkedNode<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new MyLinkedNode<>(val);
        }
    }

    void addInTheHead(T val) {
        if (head.value == null) {
            head.value = val;
        } else {
            MyLinkedNode<T> newNode = new MyLinkedNode<>(val);
            newNode.next = head;
            head = newNode;
        }
    }

    void insertAtIndex(int index, T val) {
        int level = 0;
        if (head == null && index != 0) {
            throw new IndexOutOfBoundsException();
        }
        else {
            MyLinkedNode<T> newNode = new MyLinkedNode<>(val);

            MyLinkedNode<T> prev = null;
            MyLinkedNode<T> curr = head;
            while (curr != null && level <= index - 1) {
                level += 1;
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
            newNode.next = curr;
        }
    }

    boolean search(T val) {
        if (head.value == null) {
            return false;
        } else {
            MyLinkedNode<T> curr = head;
            while (curr != null) {
                if (curr.value == val) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }

    int length(){
        int len = 0;
        if (head.next == null) {
            return len;
        } else {
            MyLinkedNode<T> curr = head;
            while (curr != null) {
                len ++;
                curr = curr.next;
            }
            return len;
        }
    }

    boolean deleteByValue(T val) {
        if (head == null) {
            return false;
        } else {
            MyLinkedNode<T> prev;
            MyLinkedNode<T> curr = head;
            while (curr != null) {
                prev = curr;
                curr = curr.next;
                if (curr.value == val) {
                    prev.next = curr.next;
                    return true;
                }
            }
            return false;
        }
    }

    void traverse(){
        MyLinkedNode<T> curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    void reverse(){
        if (head == null) {
            return;

        } else {
            List<T> set = new ArrayList<>();

            MyLinkedNode<T> prev = null;
            MyLinkedNode<T> curr = head;
            MyLinkedNode<T> nt;

            while (curr != null) {
                nt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nt;
            }
            head = prev;
        }
    }
}

class TestLinkedList {
    public static void main (String[] ars) {
        MySinglyLinkedList<Integer> myTest = new MySinglyLinkedList<>();
        myTest.addToTheTail(1);
        myTest.addToTheTail(2);
        myTest.addToTheTail(22);
        myTest.addInTheHead(45);
        myTest.traverse();
        System.out.println(myTest.search(22));
        System.out.println(myTest.search(12));
        myTest.insertAtIndex(2, 63);


        myTest.traverse();
        myTest.deleteByValue(63);
        System.out.println();
        myTest.traverse();
        System.out.printf("The length of the list is %d", myTest.length());

        System.out.println();

        myTest.reverse();


        myTest.traverse();
    }
}