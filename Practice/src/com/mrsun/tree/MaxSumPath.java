package com.mrsun.tree;

/**
 * Given a tree, get the path from root to leaf such that the sum of nodes in
 * the path is maximum.
 */
public class MaxSumPath {

    public static class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    int max = 0;
    String path = "";

    public void maxPath(Node node, int sum, String p) {
        sum += node.value;
        if (node.left == null && node.right == null) {
            if (sum > max) {
                max = sum;
                path = p + " -> " + node.value;
                return;
            }
        }
        if (node.left != null) {
            maxPath(node.left, sum, p + " ->" + node.value);
        }
        if (node.right != null) {
            maxPath(node.right, sum, p + " ->" + node.value);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.left.left.left = new Node(5);

        MaxSumPath ms = new MaxSumPath();
        ms.maxPath(root, 0, "");
        System.out.println("Max:" + ms.max);
        System.out.println("Path:" + ms.path);
    }
}
