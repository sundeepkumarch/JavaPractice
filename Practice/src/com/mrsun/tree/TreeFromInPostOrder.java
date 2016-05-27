package com.mrsun.tree;

/**
 *
 * @author sundeep
 */
public class TreeFromInPostOrder {

    public static Node build(int[] in, int[] post, int start, int end, int pIndex) {

        //Base case
        if (start > end) {
            return null;
        }
        Node node = new Node(post[pIndex--]);

        if (start == end) {
            return node;
        }
        int index = search(in, start, end, node.data);

        node.right = build(in, post, index + 1, end, pIndex);
        node.left = build(in, post, start, index - 1, pIndex);

        return node;
    }

    private static int search(int[] arr, int start, int end, int data) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == data) {
                break;
            }
        }
        return i;
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;
        Node node = build(in, post, 0, n - 1, n - 1);
        inOrder(node);
    }
}
