package com.mrsun.questions;

/**
 * A number starting from 1 can be got by either multiplying 3 or adding 5 to
 * it. Given a number, find the sequence of operations to get it or say it’s not
 * possible. Ex: 13 is 1 * 3 + 5 + 5 but 15 you cannot get.
 */
public class IntuitS1Q2 {

    public static void main(String[] args) {
        int start = 2;
        int goal = 27;
        
        new IntuitS1Q2().find(start, goal);
    }

    private String findUtil(int start, int goal, String str) {
        if (start == goal) {
            return str;
        }
        if (start > goal) {
            return null;
        }
        String str1 = findUtil(start + 5, goal, "(" + str + " + 5 ) ");
        String str2 = findUtil(start * 3, goal, "(" + str + " * 3 )");

        return str1 != null ? str1 : str2 != null ? str2 : null;
    }

    public void find(int start, int goal) {

        String str = findUtil(start, goal, start + "");

        if (str != null) {
            System.out.println("Found sequence : " + str);
        } else {
            System.out.println("Sequence not found");
        }
    }
}
