package com.mrsun.linkedlist;

/**
 *
 * @author sundeep
 */
public class ReverseLinkedList {

    public static Node reverse(Node n) {
        Node prev = null;
        Node curr = n;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        
        print(node);
        print(reverse(node));
    }

    public static void print(Node a) {
        while (a != null) {
            System.out.print(a.data + "->");
            a = a.next;
        }
        System.out.println();
    }
}
