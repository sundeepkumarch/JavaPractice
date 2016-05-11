package com.mrsun.tree;

/**
 *
 * @author sundeep
 */
public class IsSubTree {

    public boolean areIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;//??
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        boolean flag = (node1.data == node2.data) && areIdentical(node1.left, node2.left) && areIdentical(node1.right, node2.right);

        return flag;
    }
}
