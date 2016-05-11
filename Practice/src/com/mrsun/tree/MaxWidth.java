package com.mrsun.tree;

/**
 *
 * @author sundeep
 */
public class MaxWidth {

    public int getMaxWidth(Node node) {
        int h = getHeight(node);
        int count[] = new int[h];
        int level = 0;
        getMaxWidthRec(node, count, level);
        return getMax(count);
    }

    public void getMaxWidthRec(Node node, int[] count, int level) {
        if (node != null) {
            count[level]++;
            getMaxWidthRec(node.left, count, level + 1);
            getMaxWidthRec(node.right, count, level + 1);
        }
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lh = getHeight(node.left);
            int rh = getHeight(node.right);

            return lh > rh ? lh + 1 : rh + 1;
        }
    }

    private int getMax(int[] count) {
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args){
        MaxWidth m = new MaxWidth();

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(8);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(7);
        
        System.out.println("Width = "+m.getMaxWidth(node));
            
        
    }
}
