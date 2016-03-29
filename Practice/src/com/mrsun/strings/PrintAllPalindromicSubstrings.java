package com.mrsun.strings;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sundeep
 */
public class PrintAllPalindromicSubstrings {

    public Set<String> printAll(String s) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int j = i, k = i + 1;
           // res.add(s.charAt(i) + "");
            for (int it = 0; it < 2; it++) {
                if (it == 1) {
                    j = i - 1;
                    k = i + 1;
                    sb.setLength(0);
                    sb.append(s.charAt(i));
                }
                while (j >= 0 && k < s.length()) {
                    if (s.charAt(j) == s.charAt(k)) {
                        sb.insert(0, s.charAt(j));
                        res.add(sb.append(s.charAt(k)).toString());
                        j--;
                        k++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PrintAllPalindromicSubstrings p = new PrintAllPalindromicSubstrings();
        for (String s : p.printAll("abcbad")) {
            System.out.println(s);
        }
    }
}
