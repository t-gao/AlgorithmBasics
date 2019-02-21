package com.tony.algorithm.leetcode.linkedlist;

import java.util.HashSet;

public class CheckCircle {

    public static void main(String... args) {
        int size = 10;
        Node head = LinkedListUtil.generateList(size, 8);
        LinkedListUtil.printLinkedList(head, size + 1);
        System.out.println();

        long begin = System.currentTimeMillis();
        System.out.println("begin: " + begin);

//        boolean result = hasCircle(head);
//        Node circleStart = detectCircleStart(head);
//        int circleStartPos = detectCircleStartPosition(head);

        boolean result = hasCircle2(head);
        Node circleStart = detectCircleStart2(head);
        int circleStartPos = detectCircleStartPosition2(head);
        int circleLen = detectCircleLength2(head);

        long end = System.currentTimeMillis();

        System.out.println("has circle: " + result);
        System.out.println("circleStart: " + circleStart);
        System.out.println("circleStartPos: " + circleStartPos);
        System.out.println("circleLen: " + circleLen);

        System.out.println("end: " + end + ", cost: " + (end - begin));
    }

    /**
     * Hash 法，判断是否有环。
     * （ 100000 个节点，环起点在 50000 时，耗时 41 毫秒）
     * @param head
     * @return
     */
    public static boolean hasCircle(Node head) {
//        HashSet<Integer> visited = new HashSet<>();
        HashSet<Node> visited = new HashSet<>();
        while (head != null) {
//            int hash = head.hashCode();
//            if (visited.contains(hash)) {
            if (visited.contains(head)) {
                return true;
            } else {
                visited.add(head);
                head = head.next;
            }
        }

        return false;
    }

    /**
     * Hash 法，找到环的起点节点
     * @param head
     * @return
     */
    public static Node detectCircleStart(Node head) {
//        HashSet<Integer> visited = new HashSet<>();
        HashSet<Node> visited = new HashSet<>();
        while (head != null) {
//            int hash = head.hashCode();
//            if (visited.contains(hash)) {
            if (visited.contains(head)) {
                return head;
            } else {
                visited.add(head);
                head = head.next;
            }
        }
        return null;
    }

    /**
     * Hash 法，找到环的起点节点距离头结点的距离
     * @param head
     * @return
     */
    public static int detectCircleStartPosition(Node head) {
//        HashSet<Integer> visited = new HashSet<>();
        HashSet<Node> visited = new HashSet<>();
        Node h = head, p = null;
        while (h != null) {
//            int hash = h.hashCode();
//            if (visited.contains(hash)) {
            if (visited.contains(h)) {
                p = h;
                break;
            } else {
                visited.add(h);
                h = h.next;
            }
        }

        if (p == null) {
            return -1;
        } else {
            int i=0;
            h = head;
            while (h != null && h != p) {
                i++;
                h = h.next;
            }
            return i;
        }
    }

    /**
     * 快慢指针法（双指针法、龟兔赛跑法），判断是否有环。
     *
     * （100000 个节点，环起点在 50000 时，耗时 1 毫秒）
     *
     * @param head
     * @return
     */
    public static boolean hasCircle2(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 快慢指针法（双指针法、龟兔赛跑法），找到环的起点节点。
     * @param head
     * @return
     */
    public static Node detectCircleStart2(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        // let slow stay at meeting point, while move fast back to head.
        // this time, the two pointers have same speed 1.
        // 让 slow 留在相遇点，让 fast 回到 head。这次让两者速度都为 1。
        Node meet = slow;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    /**
     * 快慢指针法（双指针法、龟兔赛跑法），找到环的起点节点距离头结点的距离。
     * @param head
     * @return
     */
    public static int detectCircleStartPosition2(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return -1;
        }

        // let slow stay at meeting point, while move fast back to head.
        // this time, the two pointers have same speed 1.
        // 让 slow 留在相遇点，让 fast 回到 head。这次让两者速度都为 1。
        fast = head;
        int pos = 0;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            pos++;
        }

        return pos;
    }

    /**
     * 快慢指针法（双指针法、龟兔赛跑法），计算环的长度。
     *
     * 快指针 fast 每次移动 2 步，慢指针 slow 每次移动 1 步；
     *
     * 如果无环：
     *     那么 fast 或 slow 总会变成 null，循环会结束，退出；
     *
     * 如果有环：
     *     那么 fast 和 slow 一定会相遇。在 slow 进圈前，fast 可能已经走了不止一圈
     *     则当两者相遇时：
     *          1. fast 比 slow 多走了 n(n >= 1) 圈的距离
     *          2. 由于 fast 的速度是 slow 的两倍，则 fast 走过的路程是 slow 的两倍
     *     由以上两条可知，。
     *
     * @param head 链表头指针
     * @return 无环返回 0， 否则返回环的长度。
     */
    public static int detectCircleLength2(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return 0;
        }

        // let slow stay at meeting point, while let fast to move with speed 1,
        // when they meet again, fast has traveled the whole circle.
        // 让 slow 留在相遇点，让 fast 速度 1 继续移动，
        // 当两者再次相遇时，fast 走过的路程就是一圈的长度。
        int len = 0;
        do {
            fast = fast.next;
            len++;
        } while (fast != slow);

        return len;
    }
}
