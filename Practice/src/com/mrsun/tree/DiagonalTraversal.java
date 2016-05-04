package com.mrsun.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author sundechi
 */
public class DiagonalTraversal {

    static void printDiagonal(Node root, int d, Map<Integer, List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (result.get(d) == null) {
            result.put(d, new ArrayList<>());
        }
        result.get(d).add(root.data);

        printDiagonal(root.left, d + 1, result);

        printDiagonal(root.right, d, result);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        Map<Integer, List<Integer>> result = new HashMap<>();

        printDiagonal(root, 0, result);
        
        for(Entry e : result.entrySet()){
            int d = (int) e.getKey();
            for(int v : result.get(d)){
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }
}
