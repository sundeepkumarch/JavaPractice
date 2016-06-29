package com.nearme.util;

import com.nearme.model.User;
import java.util.HashMap;
import javax.faces.bean.ApplicationScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sundechi
 */
@ApplicationScoped
public class UserUtil {

    public UserUtil() {

    }

    public static HashMap getUserData() {
        HashMap<String, User> userMap = new HashMap<>();
        userMap.put("933", new User("933", "Kailash Plaza"));
        userMap.put("101", new User("101", "Ansal Chamber"));
        userMap.put("123", new User("123", "Janta Mazdoor Colony"));
        userMap.put("122", new User("122", "Defence Colony"));
        userMap.put("134", new User("134", "Shankar Vihar"));
        userMap.put("156", new User("156", "saneja Tower Iidistt"));
        userMap.put("178", new User("178", "Centresaket"));
        userMap.put("189", new User("189", "Ishwar Nagar"));
        userMap.put("121", new User("121", "Khan Market"));
        userMap.put("423", new User("423", "697 Chandni Chowk"));
        userMap.put("143", new User("143", "696 Chandni Chowk"));
        userMap.put("149", new User("149", "E-15 Rajouri Garden"));
        userMap.put("572", new User("572", "Kkk Delhi"));
        return userMap;
    }

}
