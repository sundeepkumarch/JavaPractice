package com.mrsun.tree;

import java.util.Stack;

/**
 * Inorder traversal without using recursion
 *
 * @author sundechi
 */
public class InorderTraversalwithStack {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        traverse();
    }

    static void traverse() {

        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        Node current = root;

        while (current != null) {
            s.push(current);
            current = current.left;
        }

        while (s.size() > 0) {
            current = s.pop();
            System.out.print(current.data + " ");
            if (current.right != null) {
                current = current.right;

                while (current != null) {
                    s.push(current);
                    current = current.left;
                }
            }
        }
    }
}
