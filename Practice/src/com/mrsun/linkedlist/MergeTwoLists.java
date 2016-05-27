package com.mrsun.linkedlist;

/**
 * Given two sorted singly linked lists having n and m elements each, merge them
 * using constant space. First n smallest elements in both the lists should
 * become part of first list and rest elements should be part of second list.
 * Sorted order should be maintained. We are not allowed to change pointers of
 * first linked list.
 *
 * @author sundeep
 */
public class MergeTwoLists {

    public static void merge(Node a, Node b) {
        while (a != null && b != null) {
            if (a.data > b.data) {
                //Swap data
                int t = a.data;
                a.data = b.data;
                b.data = t;

                Node temp = b;

                if (b.next != null && b.data > b.next.data) {
                    b = b.next;
                    
                    Node tNode = b;
                    b.next.next = b;
                    b.next = tNode;
                }

            }
            a = a.next;
        }
    }

    public static void main(String[] args) {

        Node a = new Node(2);
        a.next = new Node(4);
        a.next.next = new Node(7);
        a.next.next.next = new Node(8);
        a.next.next.next.next = new Node(10);

        Node b = new Node(1);
        b.next = new Node(3);
        b.next.next = new Node(12);

        merge(a, b);

        print(a);
        print(b);
    }

    public static void print(Node a) {
        while (a != null) {
            System.out.print(a.data + "->");
            a = a.next;
        }
        System.out.println();
    }
}
