//Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

//Time & Space Complexity: O(V+E) O(V)

class Solution {
    // Function to detect cycle in an undirected graph.
    boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int n : adj.get(node)){
            if(vis[n]==false){
                if(dfs(n, node, vis, adj) == true)
                    return true;
            }else if(parent != n){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i]==false){
                if(dfs(i, -1, vis, adj)==true)
                    return true;
            }
        }
        return false;
    }
}
