package com.tony.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {

    public static void main(String... args) {

        int size = 10;
        Node head = LinkedListUtil.generateList(size);
        LinkedListUtil.printLinkedList(head, size);
        System.out.println();

        long begin = System.currentTimeMillis();
        System.out.println("begin: " + begin);

        head = reverseLinkedList(head);

        long end = System.currentTimeMillis();
        System.out.println("end: " + end + ", cost: " + (end - begin));

        LinkedListUtil.printLinkedList(head, size);
    }

    /**
     * 反转单链表，返回反转后的单链表的头指针
     * @param head 原单链表头指针
     * @return 反转后的单链表的头指针
     */
    public static Node reverseLinkedList(Node head) {
        Node cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
