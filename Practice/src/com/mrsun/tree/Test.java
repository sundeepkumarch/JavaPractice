/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrsun.tree;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sundechi
 */
public class Test {
    public static void main(String[] args){
        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(new Node(10));
        nodeSet.add(new Node(20));
        nodeSet.add(new Node(30));
        nodeSet.add(new Node(10));
        nodeSet.add(new Node(20));
 
        System.out.println(nodeSet.size());
    }
}
