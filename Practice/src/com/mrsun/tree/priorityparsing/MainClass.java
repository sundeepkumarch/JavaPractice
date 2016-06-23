package com.mrsun.tree.priorityparsing;

public class MainClass {

    public void parse(Account account) {
        if (account.children.isEmpty()) {
            return;
        }
        for (int priority = 1; account.children.size() >= priority; priority++) {
            Account child = account.children.get(priority);
            System.out.println(child.accNo);
            parse(child);
        }
        
        
    }

    public Account populateData() {
        Account root = new Account("A");
        Account b1 = new Account("B1");
        Account b2 = new Account("B2");
        Account b = new Account("B");
        b.children.put(1, b2);
        b.children.put(2, b1);

        Account c = new Account("C");

        Account d1 = new Account("D1");
        Account d2 = new Account("D2");
        Account d = new Account("D");
        d.children.put(1, d1);
        d.children.put(2, d2);

        root.children.put(1, c);
        root.children.put(2, b);
        root.children.put(3, d);
        return root;
    }

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        Account root = mc.populateData();
        mc.parse(root);

    }
}
