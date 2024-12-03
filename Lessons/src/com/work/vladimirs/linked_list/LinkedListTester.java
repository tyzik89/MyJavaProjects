package com.work.vladimirs.linked_list;

import java.util.Random;
import java.util.Scanner;

public class LinkedListTester {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String nodes = console.nextLine();
        nodes = new StringBuilder(nodes).reverse().toString();
        String[] splitNodes = nodes.split("");

//        ListNode testListNodeHead = new ListNode(Integer.parseInt(splitNodes[0]), null);
//        for (int i = 1; i < splitNodes.length; i++) {
//            testListNodeHead = new ListNode(Integer.parseInt(splitNodes[i]), testListNodeHead);
//        }
//        System.out.print("Initial: ");
//        prettyPrintListNode(testListNodeHead);

//        ListNode head = removeNthFromEnd(testListNodeHead, 3);
//        ListNode head = reverseListIteratively(testListNodeHead);
//        ListNode head = reverseListRecursively(testListNodeHead);
//        ListNode head = mergeElementWithList(testListNodeHead, new ListNode(3));
//        ListNode head = mergeTwoLists(testListNodeHead,
//                new ListNode(2,
//                        new ListNode(4,
//                                new ListNode(6)
//                        )
//                )
//        );

//        boolean isPalindrome = isPalindrome(testListNodeHead);
//        System.out.print("Result: " + (isPalindrome ? "Yes, it's palindrome" : "No"));


        ListNode cyclicNode = null;
        ListNode testListNodeHead = new ListNode(Integer.parseInt(splitNodes[0]), null);
        ListNode tail = testListNodeHead;
        int random = new Random().nextInt(splitNodes.length == 1 ? 1 : splitNodes.length - 1) + 1;
        for (int i = 1; i < splitNodes.length; i++) {
            testListNodeHead = new ListNode(Integer.parseInt(splitNodes[i]), testListNodeHead);
            if (i == random) {
                cyclicNode = testListNodeHead;
            }
        }
        tail.next = cyclicNode;
        System.out.println("Pos: " + random);

        boolean hasCycle = hasCycle(testListNodeHead);
        System.out.print("Result: " + (hasCycle ? "Yes, it's has cycle" : "No cycles"));

//        System.out.print("Result: ");
//        prettyPrintListNode(head);
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (true) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == null) return false;
            if (slow == fast) return true;
        }
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // Find middle of the LinkedList
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Change links vice versa. From the end to the middle
        ListNode prev = null, next;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // Compare step by step (first == last, second == penultimate)
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        prettyPrintListNode(head);
        // Recover initial LinkedList
//        prettyPrintListNode(head);
        return true;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        System.out.print("Merge with: ");
        prettyPrintListNode(list2);
        ListNode firstDummy = new ListNode(-1, null);
        ListNode tail = firstDummy;
        while (true) {
            if (list1 == null) {
                tail.next = list2;
                break;
            } else if (list2 == null) {
                tail.next = list1;
                break;
            }

            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        return firstDummy.next;
    }

    private static ListNode mergeElementWithList(ListNode head, ListNode elemNode) {
        if (head == null) return elemNode;
        ListNode curr = head;
        ListNode firstDummy = new ListNode(-1, head);
        ListNode prev = firstDummy;

        while (curr != null) {
            if (curr.val >= elemNode.val) {
                prev.next = elemNode;
                elemNode.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (prev.val < elemNode.val) {
            prev.next = elemNode;
        }
        return firstDummy.next;
    }

    private static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursively(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1, p2;
        ListNode firstDummy = new ListNode(0, head);
        p1 = p2 = firstDummy;
        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return firstDummy.next;
    }

    private static void prettyPrintListNode(ListNode head) {
        if (head == null) {
            System.out.print("null");
            System.out.println();
        } else {
            System.out.print(head.val + " -> ");
            prettyPrintListNode(head.next);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
