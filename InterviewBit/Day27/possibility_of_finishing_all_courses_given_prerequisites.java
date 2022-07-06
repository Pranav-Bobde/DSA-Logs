//Link: https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    
    int dfs(int node, boolean[] vis, boolean[] dfsvis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        dfsvis[node] = true;
        
        for(int n: adj.get(node)){
            if(dfsvis[n]) return 0;
            if(dfs(n, vis, dfsvis, adj) == 0){
                return 0;
            }
        }
        dfsvis[node] = false;
        
        return 1;
    }
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<A+1; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0; i<B.size(); i++){
            adj.get(C.get(i)).add(B.get(i));
        }
        
        boolean[] vis = new boolean[A+1];
        boolean[] dfsvis = new boolean[A+1];
        
        for(int i=1; i<=A; i++){
            if(!vis[i]){
                if(dfs(i, vis, dfsvis, adj) == 0){
                    return 0;
                }
            }
        }
        return 1;
    }
}
