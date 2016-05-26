package com.mrsun.tree;

/**
 * Given an integer ‘K’ and a tree in string format. We had to print the sum of all elements at Kth level from root.
 * Tree was given in the form: (node value(left subtree)(right subtree))
 * @author sundeep
 */
public class SumAtLevel {

    public static void main(String[] args) {
        /*
                             0
                          /     \
                       5         7
                    /    \      /   \
                   6       4    1     3
                            \
                             9 
*/
        String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        int level = -1;
        int sum = 0;

        for (int i = 0; i < tree.length(); i++) {
            if (tree.charAt(i) == '(') {
                ++level;
            } else if (tree.charAt(i) == ')') {
                --level;
            } else if (level == k) {
                sum += ((int) tree.charAt(i)-48);
            }
        }
        System.out.println("Sum = " + sum);
    }
}
