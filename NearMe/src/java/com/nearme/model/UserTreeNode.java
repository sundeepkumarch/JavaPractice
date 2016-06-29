/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nearme.model;

public class UserTreeNode {

    public double[] cord = new double[2];
    public int axis;
    public String id;
    public boolean checked;
    public boolean orientation;
    public UserTreeNode Parent;
    public UserTreeNode Left;
    public UserTreeNode Right;

    public UserTreeNode(double[] dim, int axis, String id) {

        this.axis = axis;
        this.cord[0] = dim[0];
        this.cord[1] = dim[1];

        Left = Right = Parent = null;
        checked = false;
        this.id = id;

    }

    public UserTreeNode FindParent(double[] cordinates) {
        UserTreeNode parent = null;
        UserTreeNode next = this;
        int laxis;
        while (next != null) {
            laxis = next.axis;
            parent = next;
            if (cordinates[laxis] > next.cord[laxis]) {
                next = next.Right;
            } else {
                next = next.Left;
            }
        }

        return parent;
    }

    public UserTreeNode Insert(double[] p, String id) {

        UserTreeNode parent = FindParent(p);

        if (checkIfSame(p, parent.cord) == true) {
            return null;
        }
        UserTreeNode newNode = new UserTreeNode(p, parent.axis == 0 ? 1 : 0, id);
        newNode.Parent = parent;
        if (p[parent.axis] > parent.cord[parent.axis]) {

            parent.Right = newNode;
            newNode.orientation = true; //
        } else {

            parent.Left = newNode;
            newNode.orientation = false; //
        }
        
        return newNode;
    }

    public boolean checkIfSame(double[] cor1, double[] cor2) {
        if (cor1[0] == cor2[0] && cor1[1] == cor2[1]) {
            return true;
        } else {
            return false;
        }
    }

    public double distanceBetween(double[] cor1, double[] cor2) {
        double S = 0;
        double x = (cor1[0] - cor2[0]) * (cor1[0] - cor2[0]);
        double y = (cor1[1] - cor2[1]) * (cor1[1] - cor2[1]);
        S = java.lang.Math.sqrt((x + y));
        return S;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
