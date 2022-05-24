package com.citrys.app.facebook;

public class CircleInTheList {
}
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycleLength {

    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return countCircle(slow);
            }
        }
        return 0;
    }

    public static int countCircle(ListNode node) {
        int count = 0;
        ListNode current;
        do {
            current = node.next;
            count ++;
        } while (current != node);
        return count;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}