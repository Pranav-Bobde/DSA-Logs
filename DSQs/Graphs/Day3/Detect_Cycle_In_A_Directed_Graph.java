//Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/

//Time & Space Complexity: O(N) O(N)

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] dfsvis = new int[V];
        
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                if(check(i, vis, dfsvis, adj) == true)
                    return true;
            }
        }
        return false;
    }
    
    boolean check(int node, int[] vis, int[] dfsvis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        dfsvis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(check(it, vis, dfsvis, adj) == true)
                    return true;
            }else if(dfsvis[it] == 1){
                return true;
            }
        }
        dfsvis[node] = 0;
        return false;
    }
}
