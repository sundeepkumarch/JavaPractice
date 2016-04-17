package com.mrsun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=1585&rd=6535
 *
 * @author sundechi
 */
public class BusinessTasks {

    public String getTask(String[] list, int n) {
        List<String> taskList = new ArrayList<>(Arrays.asList(list));
        boolean flag = true;
        while (flag) {
            taskList.remove(n - 1);
            System.out.println("Size=" + taskList.size());
            System.out.println(taskList);
        }
        return null;
    }

    public static void main(String[] args) {
        BusinessTasks tasks = new BusinessTasks();
        tasks.getTask(new String[]{"a", "b", "c", "d"}, 2);
    }
}
