package com.mrsun.tree;

/**
 *
 * @author sundeep
 */
public class PrintAncestors {

    public static boolean printAncestors(Node node, int k) {
        if (node == null) {
            return false;
        }
        if (node.data == k) {
            return true;
        }
        if (printAncestors(node.left, k) || printAncestors(node.right, k)) {
            System.out.print(node.data + ">");
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(8);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(7);
        
        printAncestors(node, 7);
    }
}
