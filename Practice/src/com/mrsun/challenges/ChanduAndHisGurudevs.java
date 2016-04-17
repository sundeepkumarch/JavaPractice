package com.mrsun.challenges;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class ChanduAndHisGurudevs {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for(int t = 0; t < T; t++){
            Set<Edge> edgesSet = new HashSet<>();
            Set verticesSet = new HashSet();
            int N = Integer.parseInt(br.readLine());
            for(int i = 1; i < N-1; i++){
                String edges = br.readLine();
                int v1 = Integer.parseInt(edges.split(" ")[0]);
                int v2 = Integer.parseInt(edges.split(" ")[1]);
                int w = Integer.parseInt(edges.split(" ")[1]);
                verticesSet.add(v1);
                verticesSet.add(v2);
                edgesSet.add(new Edge(v1,v2,w));
            }
            
        }
    }
    public void F(int a, int b){
        
    }
    public static class Edge{
        int v1;
        int v2;
        int w;
        public Edge(int v1, int v2, int w){
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
        public int getWeight(){
            return w;
        }
    }
}
