/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nearme.util;

import com.nearme.appService.UserTree;
import com.nearme.model.Cordinates;
import com.nearme.model.UserTreeNode;
import java.util.HashMap;

/**
 *
 * @author sundechi
 */
public class Utility {

    static HashMap<String, Cordinates> sampleData = null;

    public static double[] getDimension(String location) {

        // here work on getting address and plot on graph
        if (sampleData == null) {
            exampledata();
        }
        Cordinates cor = sampleData.get(location);
        double dim[] = {cor.getX(), cor.getY()};
        return dim;
    }

    private static HashMap exampledata() {
        if (sampleData == null) {
            sampleData = new HashMap<>();
        }

        sampleData.put("Kailash Plaza", new Cordinates(12.3, 14.5));
        sampleData.put("Ansal Chamber", new Cordinates(1.45, 1.35));
        sampleData.put("Janta Mazdoor Colony", new Cordinates(14.3, 1.5));
        sampleData.put("Defence Colony", new Cordinates(13.45, 23.42));
        sampleData.put("Shankar Vihar", new Cordinates(54.3, 1.5));
        sampleData.put("saneja Tower Iidistt", new Cordinates(12.45, 60.2));
        sampleData.put("Centresaket", new Cordinates(70.3, 34.5));
        sampleData.put("Ishwar Nagar", new Cordinates(100.45, 0.35));
        sampleData.put("Khan Market", new Cordinates(12.3, 104.15));
        sampleData.put("Rajpur Road Civil Lines", new Cordinates(17.45, 16.35));
        sampleData.put("697 Chandni Chowk", new Cordinates(170.45, 116.35));
        sampleData.put("696 Chandni Chowk", new Cordinates(172.00, 110.21));
        sampleData.put("E-15 Rajouri Garden", new Cordinates(117.45, 120.10));
        sampleData.put("Kkk Delhi", new Cordinates(40.15, 12.35));
        sampleData.put("Chandni Chowk", new Cordinates(172.00, 110.21));
        sampleData.put("124 Chandni Chowk", new Cordinates(192.00, 140.41));
        sampleData.put("Airport", new Cordinates(12.00, 10.41));

        return sampleData;
    }

    public static void printUser(UserTree userTree ,String sid,int range) {
        HashMap<String, UserTreeNode> nearNeigh = userTree.findRangeUser(Utility.getDimension(sid), range);
        System.out.println("Within Range User Ids :");
        for (String id : nearNeigh.keySet()) {
            System.out.print(nearNeigh.get(id).getId() + " ");
        }
    }

}
