package com.mrsun.tree;

/**
 * Left view of a tree contains all nodes that are first nodes in their levels.
 * @author sundeep
 */
public class LeftView {
    
   static int max_level = 0;
    
    public static void leftView(Node node, int level){
        if(node == null){
            return;
        }
        if(max_level < level){
            System.out.print(node.data+" ");
            max_level = level;
        }
        leftView(node.left, level+1);
        leftView(node.right, level+1);
    }
    
    public static void main(String[] args){
        Node node = new Node(12);
        node.left = new Node(10);
        node.right = new Node(30);
        node.right.left = new Node(25);
        node.right.right = new Node(40);
        leftView(node, 1);
        
    }
}
