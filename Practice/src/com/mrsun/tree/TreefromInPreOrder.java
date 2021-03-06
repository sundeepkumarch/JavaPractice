package com.mrsun.tree;

/**
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 *
 * @author sundechi
 */
public class TreefromInPreOrder {

    static int preIndex = 0;

    public static Node buildTree(int[] in, int[] pre, int start, int end) {

        // Base case
        if (start > end) {
            return null;
        }
        Node node = new Node(pre[preIndex++]);

        //If this node has no children then return 
        if (start == end) {
            return node;
        }
        //Else find the index of this node in Inorder traversal
        int inIndex = search(in, start, end, node.data);
        
        //Using index in Inorder traversal, construct left and right subtress
        node.left = buildTree(in, pre, start, inIndex - 1);
        node.right = buildTree(in, pre, inIndex + 1, end);

        return node;
    }

    static int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        int[] in = {};
        int[] pre = {};
        Node n = buildTree(in, pre, 0, in.length - 1);
        printInorder(n);
    }
}
