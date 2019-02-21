package com.tony.algorithm.leetcode.linkedlist;

public class Node {
    public int value = -1;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ value: " + value + ", next: " + (next == null ? "null" : next.value) + "}";
    }
}
