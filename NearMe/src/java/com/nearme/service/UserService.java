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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author sundechi
 */
@Path("user")
public class UserService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserService
     */
    public UserService() {
    }

    /**
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<String> getJson() {
        ArrayList<String> nearUserList = new ArrayList<>();

        UserUtil util = new UserUtil();
        HashMap<String, User> userMap = util.getUserData();
        UserTree userTree = new UserTree(util.getUserData().size());
        for (String userId : userMap.keySet()) {
            userTree.add(userMap.get(userId).getAddress().dimensions, userId);
        }

        HashMap<String, UserTreeNode> nearNeigh = userTree.findRangeUser(Utility.getDimension("Ansal Chamber"), 30);
       
        for (String id : nearNeigh.keySet()) {
            nearUserList.add(nearNeigh.get(id).getId());
        }
        return nearUserList;

    }

}
