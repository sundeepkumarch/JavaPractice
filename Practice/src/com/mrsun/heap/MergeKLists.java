package com.mrsun.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author sundeep
 */
public class MergeKLists {

    public Node mergeKLists(ArrayList<Node> lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>(lists.size(), new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.x > b.x) {
                    return 1;
                } else if (a.x == b.x) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (Node node : lists) {
            queue.add(node);
        }

        Node head = new Node(0);
        Node n = head;

        while (queue.size() > 0) {
            Node temp = queue.poll();

            n.next = temp;

            if (temp.next != null) {
                queue.add(temp.next);
            }
            n = n.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ArrayList<Node> list1 = new ArrayList<>();

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(7);
        head1.next.next.next = new Node(15);

        list1.add(head1);

        Node head2 = new Node(3);
        head2.next = new Node(5);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(14);

        list1.add(head2);

        Node head3 = new Node(4);
        head3.next = new Node(6);
        head3.next.next = new Node(8);
        head3.next.next.next = new Node(11);

        list1.add(head3);

        MergeKLists m = new MergeKLists();
        Node h = m.mergeKLists(list1);
        printList(h);
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.x + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static class Node {

        int x;
        Node next;

        public Node(int x) {
            this.x = x;
            this.next = null;
        }
    }
}
