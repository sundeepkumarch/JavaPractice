package com.mrsun.tree;

/**
 *
 * @author sundeep
 */
public class TreeFromTraversals {

    public static Node build(int[] in, int[] pre, int start, int end) {
        int preIndex = 0;
        if (start > end) {
            return null;
        }
        Node node = new Node(pre[preIndex]);
        preIndex++;

        if (start == end) {
            return node;
        }

        int searchind = search(in, start, end, node.data);
        node.left = build(in, pre, start, searchind - 1);
        node.right = build(in, pre, searchind + 1, end);

        return node;
    }

    private static int search(int[] in, int start, int end, int data) {
        int i = start;
        for(; i < end; i++){
            if(in[i] == data){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] in = {4,2,5,1,6,3,7};
        int[] pre = {1,2,4,5,3,6,7};
        int n = 7;
        
        Node root = build(in, pre, 0, n);
        System.out.println(root.data);
    }

}
