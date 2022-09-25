//Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

//Time & Space: O(N) O(N)

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ans){
        vis[node] = 1;
        ans.add(node);
        for(int n : adj.get(node)){
            if(vis[n]!=1){
                dfs(n, adj, vis, ans);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i]!=1)
                dfs(i, adj, vis, ans);
        }
        return ans;
    }

