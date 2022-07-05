//Link: https://www.interviewbit.com/problems/path-in-directed-graph/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<=A; i++)
            adj.add(new ArrayList<Integer>());
        
        for(ArrayList<Integer> al : B){
            adj.get(al.get(0)).add(al.get(1));
        }
        
        boolean[] vis = new boolean[A+1];
        
        return dfs(1, A, vis, adj);
    }
    
    int dfs(int node, int A, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        if(vis[node]) return 0;
        if(node == A) return 1;
        
        vis[node] = true;
        
        for(int n : adj.get(node)){
            if (dfs(n, A, vis, adj) == 1)
                return 1;
        }
        
        return 0;
    }
}
