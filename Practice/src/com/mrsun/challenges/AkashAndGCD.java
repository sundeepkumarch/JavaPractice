package com.mrsun.challenges;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AkashAndGCD {

    static Map<Integer, Integer> FMap = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] A = new int[N];
        String arrayLine = br.readLine();
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arrayLine.split(" ")[i]);
        }
        int Q = Integer.parseInt(br.readLine());
        String[] queries = new String[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = br.readLine();
        }
        
        for(String query : queries){
            String[] params = query.split(" ");
            int x = Integer.parseInt(params[1]);
            int y = Integer.parseInt(params[2]);
            int output = 0;
            if(params[0].equals("C")){
                for(int i = x; i<= y; i++){
                    Object val = FMap.get(A[i-1]);
                    if(val == null){
                        output += F(A[i-1]);
                    }else{
                        output+= (Integer)val;
                    }
                    
                }
                System.out.println(output);
            }else if(params[0].equals("U")){
                A[x-1] = y;
            }
        }
    }

    static int GCD(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b; // base case
        }
        return GCD(b, a % b);
    }
    
    static int F(int x){
        int value = 0;
        for(int i = 1; i<= x; i++){
            value += GCD(i, x);
        }
        FMap.put(x, value);
        return value;
    }
}
