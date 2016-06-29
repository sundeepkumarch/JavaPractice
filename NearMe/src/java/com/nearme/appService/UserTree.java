/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nearme.appService;

import com.nearme.model.UserTreeNode;
import java.util.HashMap;

/**
 *
 * @author sundechi
 */
public class UserTree {

    UserTreeNode rootNode;

    HashMap<String, UserTreeNode> neighbourInRange;
    int nList;
    UserTreeNode CheckedNodes[];
    int checked_nodes;

    public UserTree(int i) {
        rootNode = null;
        nList = 0;
        CheckedNodes = new UserTreeNode[i];
    }

    public void add(double[] x, String id) {
        if (rootNode == null) {
            rootNode = new UserTreeNode(x, 0, id);
        } else {
            UserTreeNode currNode;
            currNode = rootNode.Insert(x, id);

        }

    }

    public HashMap findRangeUser(double[] x, int range) {
        if (rootNode == null) {
            return null;
        }
        checked_nodes = 0;
        UserTreeNode parent = rootNode.FindParent(x);
        if (neighbourInRange == null) {
            neighbourInRange = new HashMap<>();
        }
        checkParentRoot(parent, x, range);
        uncheck();

        return neighbourInRange;
    }

    public void uncheck() {

        for (int n = 0; n < checked_nodes; n++) {
            CheckedNodes[n].checked = false;
        }

    }

    public void checkParentRoot(UserTreeNode parent, double[] x, int range) {
        while (parent != null) {
            checkChildTree(parent, x, range);
            parent = parent.Parent;

        }

    }

    public void checkChildTree(UserTreeNode node, double[] x, int range) {
        if ((node == null) || node.checked) {
            return;
        } else {
            CheckedNodes[checked_nodes++] = node;
            node.checked = true;
            int lCord = node.axis;

            double d = node.cord[lCord] - x[lCord];
            if (d * d <= range * range) {
                if (rootNode.distanceBetween(node.cord, x) <= range) {

                    neighbourInRange.put(node.getId(), node);
                }

                checkChildTree(node.Left, x, range);
                checkChildTree(node.Right, x, range);

            } else {
                if (rootNode.distanceBetween(node.cord, x) <= range) {

                    neighbourInRange.put(node.getId(), node);
                }
                checkChildTree(node.Left, x, range);
            }
        }
    }

}
