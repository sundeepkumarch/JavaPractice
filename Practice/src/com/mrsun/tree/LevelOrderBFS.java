package com.mrsun.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author sundeep
 */
public class LevelOrderBFS {

    Node root = null;

    /*
   Time Complexity: O(n^2) in worst case. 
   For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree. 
   So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).
     */
    public void printLevelOrder(Node node) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printAtGivenLevel(root, i);
        }
    }

    /*
   Time Complexity: O(n) where n is number of nodes in the binary tree
     */
    void printLevelOrderUsingQueue() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.*/
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            //Compute the height of each subtree
            int leftH = height(node.left);
            int rightH = height(node.right);
            //use the larger one
            if (leftH > rightH) {
                return leftH + 1;
            } else {
                return rightH + 1;
            }
        }
    }

    public void printAtGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.println(node.data + " ");
        } else {
            printAtGivenLevel(node.left, level - 1);
            printAtGivenLevel(node.right, level - 1);
        }
    }

    public static void main(String[] args) {
        LevelOrderBFS tree = new LevelOrderBFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height:" + tree.height(tree.root));
        System.out.println("At Level2:");
        tree.printAtGivenLevel(tree.root, 2);
        System.out.println("----");
        tree.printLevelOrder(tree.root);
    }
}
