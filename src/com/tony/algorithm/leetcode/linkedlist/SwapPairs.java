package com.tony.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class SwapPairs {
    public static void main(String... args) {

        int size = 9;
        Node head = LinkedListUtil.generateList(size);
        LinkedListUtil.printLinkedList(head, size+1);

        long begin = System.currentTimeMillis();
        System.out.println("begin: " + begin);

        head = swapPairs1(head);
//        head = swapPairs2(head);

        long end = System.currentTimeMillis();
        System.out.println("end: " + end + ", cost: " + (end - begin));

        LinkedListUtil.printLinkedList(head, size+1);
    }

    public static Node swapPairs1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p = new Node();
        p.next = head;
        Node c, n;

        head = head.next;

        while ((c = p.next) != null && (n = c.next) != null) {
            c.next = n.next;
            n.next = c;
            p.next = n;
            p = c;
        }
        return head;
    }

    public static Node swapPairs2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p = null;
        Node c = head, n;

        head = head.next;

        while (c!= null && (n = c.next) != null) {
            c.next = n.next;
            n.next = c;
            if (p != null) {
                p.next = n;
            }
            p = c;
            c = p.next;
        }
        return head;
    }

}
