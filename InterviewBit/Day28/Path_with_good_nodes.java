//Link: https://www.interviewbit.com/problems/path-with-good-nodes/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] goodAndPath, int C, ArrayList<Integer> A){
        vis[node] = true;
        if(A.get(node-1) == 1){
            goodAndPath[0]++;
        }
        if(adj.get(node).size() == 1){
            if(goodAndPath[0] <= C){
                goodAndPath[1]++;
            }
            if(A.get(node-1) == 1){
                goodAndPath[0]--;
                return;
            }
        }
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                dfs(n, vis, adj, goodAndPath, C, A);
            }
        }
        
        if(A.get(node-1) == 1)
            goodAndPath[0]--;
    }
    
    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<=A.size(); i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(ArrayList<Integer> al : B){
            adj.get(al.get(0)).add(al.get(1));
            adj.get(al.get(1)).add(al.get(0));
        }
        
        int[] goodAndPath = new int[]{0,0};
        boolean[] vis = new boolean[A.size()+1];
        dfs(1, vis, adj, goodAndPath, C, A);
        
        return goodAndPath[1];
    }
