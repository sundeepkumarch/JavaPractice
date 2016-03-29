/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrsun.strings;

/**
 *
 * @author sundeep
 */
public class TwosCompliment {
    public static void main(String[] args){
        String input = "01000";
        char[] ch = input.toCharArray();
        int len = ch.length;
        boolean found = false;
        for(int i = len-1; i>=0; i--){
            if(ch[i] == '0'){
                if(found){
                   ch[i] = '1';
                }
            }else if(input.charAt(i) == '1'){
                if(found){
                    ch[i] = '0';
                }
                found = true;
            }
        }
        if(!found){
            StringBuilder sb = new StringBuilder("1");
            sb.append(input);
            System.out.println(sb.toString());
        } else{
            for(char c : ch){
            System.out.print(c);
        }
        }
        
    }
}
