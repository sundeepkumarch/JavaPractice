package com.mrsun.tree;

/**
 *
 * @author sundeep
 */
public class TopView {
    
    public static void topView(Node node){
        if(node == null){
            return;
        }
        topView(node.left);
        System.out.print(" "+node.data);
    }
    
    public static void main(String[] args){
        
        
        /*
              3
            /   \
           5     2
          / \   / \
         1   4 6   7
          \       /
           9     8
        */
        Node node = new Node(3);
        node.left = new Node(5);
        node.right = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(4);
        node.left.left.right = new Node(9);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.right.right.left = new Node(8);
        
        topView(node);
    }
}
