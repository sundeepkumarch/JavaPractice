package com.mrsun.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sundeep
 */
public class VerticalOrderTraversal {

    public static void traverse(Node node, int d, Map<Integer, List<Node>> map){
        if(node == null){
            return;
        }
        if(map.get(d) == null){
            map.put(d, new ArrayList<>());
        }
        map.get(d).add(node);
        traverse(node.left, d-1, map);
        traverse(node.right, d+1, map);
    }
    
    public static void main(String[] args){
        Map<Integer, List<Node>> map = new HashMap<>();
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
        
        traverse(node, 0, map);
        
        
        
    }
}
