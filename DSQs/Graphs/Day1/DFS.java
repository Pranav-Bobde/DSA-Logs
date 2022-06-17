//Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/

//Time & Space: O(N) O(N)

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfs(0,vis, ans, adj);
        
        return ans;
    }
    
    void dfs(int x, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        ans.add(x);
        vis[x] = true;
        
        for(int i: adj.get(x)){
            if(!vis[i]){
                dfs(i, vis, ans, adj);
            }
        }
        
    }
}
