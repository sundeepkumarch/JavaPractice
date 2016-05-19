package com.mrsun.strings;

/**
 *
 * @author sundeep
 */
public class NaivePatternSearching {

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern ="AABA";
        search(text,pattern);
    }

    public static void search(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();

        for (int i = 0; i < N - M; i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                int j;
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if(j == M){
                    System.out.println("pattern matched at " + i);
                }
            }
        }
    }
}
