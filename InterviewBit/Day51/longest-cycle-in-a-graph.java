//Link: https://leetcode.com/contest/weekly-contest-304/problems/longest-cycle-in-a-graph/

//Time & Space Complexity: O(N) O(N)

class Solution {
    void dfs(int node, int d, int[] ans, int[] vis, int[] dfsvis, int[] adj, int[] dist){
        if(node!=-1){
            if(vis[node] == 0){
                vis[node] = dfsvis[node] = 1;
                dist[node] = d;
                dfs(adj[node], d+1, ans, vis, dfsvis, adj, dist);
            }else if(dfsvis[node] == 1){
                ans[0] = Math.max(ans[0], d - dist[node]);
            }
            dfsvis[node] = 0;
        }
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] vis = new int[n];
        int[] dfsvis = new int[n];
        int[] dist = new int[n];
        int[] ans = new int[]{-1};
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                dfs(i, 0, ans, vis, dfsvis, edges, dist);
            }
        }
        return ans[0];
    }
}
