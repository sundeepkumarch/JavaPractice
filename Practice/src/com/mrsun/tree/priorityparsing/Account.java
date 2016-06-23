package com.mrsun.tree.priorityparsing;

import java.util.HashMap;
import java.util.Map;

public class Account {
    public String accNo;
    public String parentAccNo;
    public int priority;
    public Account parent;
    public Map<Integer, Account> children = new HashMap<>();
    public boolean visited = false;

    public Account() {
    }

    public Account(String accNo) {
        this.accNo = accNo;
    }
    
    
}
