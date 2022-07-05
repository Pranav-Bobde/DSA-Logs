//Link: https://www.interviewbit.com/problems/cycle-in-directed-graph/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    
    int dfs(int node, boolean[] vis, boolean[] dfsvis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        dfsvis[node] = true;
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                if(dfs(n, vis, dfsvis, adj) == 1){
                    return 1;
                }
            }else if(dfsvis[n]){
                return 1;
            }
        }
        
        dfsvis[node] = false;
        return 0;
    }
    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<=A; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(ArrayList<Integer> al : B){
            adj.get(al.get(0)).add(al.get(1));
        }
        
        boolean[] vis = new boolean[A+1];
        
        for(int i=1; i<=A; i++){
            if(!vis[i]){
                boolean[] dfsvis = new boolean[A+1];
                if(dfs(i, vis, dfsvis, adj) == 1)
                    return 1;
            }
        }
        return 0;
    }
}

