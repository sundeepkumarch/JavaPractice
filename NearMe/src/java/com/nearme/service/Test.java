/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nearme.service;

import com.nearme.appService.UserTree;
import com.nearme.model.User;
import com.nearme.model.UserTreeNode;
import com.nearme.util.UserUtil;
import com.nearme.util.Utility;
import java.util.HashMap;

/**
 *
 * @author sundechi
 */
public class Test {

    public static void main(String args[]) {
        UserUtil util = new UserUtil();
        HashMap<String, User> userMap = util.getUserData();
        UserTree userTree = new UserTree(util.getUserData().size());
        for (String userId : userMap.keySet()) {
            userTree.add(userMap.get(userId).getAddress().dimensions, userId);
        }

     
        Utility.printUser(userTree, "Chandni Chowk", 30);

    }

}
