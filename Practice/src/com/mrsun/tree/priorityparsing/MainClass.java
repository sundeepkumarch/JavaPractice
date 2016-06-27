package com.mrsun.tree.priorityparsing;

import java.util.Stack;

public class MainClass {

    Stack<Account> stack = new Stack<>();

    public void parse(Account account) {
        if (account == null) {
            return;
        }
        for(int p = 1; p <= account.children.size(); p++){
            Account a = account.children.get(p);
            parse(a);
            System.out.println(a.accNo);
            
        }
    }

    public Account populateData() {
        Account root = new Account("A");
        
        Account b = new Account("B");
        Account b1 = new Account("B1");
        Account b2 = new Account("B2");
        Account b3 = new Account("B3");
        b.children.put(1, b2);
        b.children.put(2, b3);
        b.children.put(3, b1);

        Account c = new Account("C");
        Account c1 = new Account("C1");
        Account c2 = new Account("C2");
        Account c11 = new Account("C11");
        Account c12 = new Account("C12");
        c1.children.put(1, c12);
        c1.children.put(2, c11);
        c.children.put(1, c1);
        c.children.put(2, c2);

        Account d = new Account("D");
        Account d1 = new Account("D1");
        Account d2 = new Account("D2");
        Account d11 = new Account("D11");
        Account d12 = new Account("D12");
        d1.children.put(1, d11);
        d1.children.put(2, d12);
        d.children.put(1, d2);
        d.children.put(2, d1);
        
        Account e = new Account("E");
        Account e1 = new Account("E1");
        Account e2 = new Account("E2");
        Account e3 = new Account("E3");
        e.children.put(1, e3);
        e.children.put(2, e2);
        e.children.put(3, e1);

        root.children.put(1, c);
        root.children.put(2, d);
        root.children.put(3, e);
        root.children.put(4, b);
        return root;
    }

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        Account root = mc.populateData();
        mc.parse(root);

    }
}
