package com.tony.algorithm.leetcode.linkedlist;

public abstract class LinkedListUtil {

    /**
     * Generate a singly linked list 生成一个单链表
     * @return the head of the generated singly linked list 生成的单链表的头
     */
    public static Node generateList(int length) {
        return generateList(length, false);
    }

    public static Node generateList(int length, boolean withCircle) {
        return generateList(length, withCircle ? (length/2 - 1) : -1);
    }

    public static Node generateList(int length, int circleStartPos) {
        Node tail = new Node(0);
        Node head = tail;

        Node circleStart = null;

        if (circleStartPos >= 0 && circleStartPos < length) {
            circleStart = head;
        }

        for (int i=1; i<length; i++) {
            Node n = new Node(i);
            tail.next = n;
            tail = n;
            if (i == circleStartPos) {
                circleStart = tail;
            }
        }
        tail.next = circleStart;

        return head;
    }

    /**
     * 打印单链表
     * @param head
     * @param lengthLimit
     */
    public static void printLinkedList(Node head, int lengthLimit) {
        Node p = head;
        System.out.println("linked list: ");
        int i = 0;
        while (p != null) {

            if (i++ >= lengthLimit) {
                break;
            }

            System.out.print(p.value);
            if (p.next == null) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
            p = p.next;

        }
    }
}
