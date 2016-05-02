package com.mrsun.tree;

/**
 *
 * @author sundechi
 */
public class BST {

    public static Node search(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        } else if (data < node.data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public static Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);;
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(27);
        root.left = new Node(14);
        root.right = new Node(35);
        root.left.left = new Node(10);
        root.left.right = new Node(19);
        root.right.left = new Node(31);
        root.right.right = new Node(42);

        Node result = search(root, 19);
        System.out.println(result == null ? "Not Found" : result.data);
        insert(root, 11);
        Node result1 = search(root, 11);
        System.out.println(result1 == null ? "Not Found" : result1.data);
    }
}
