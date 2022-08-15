//Link: https://leetcode.com/contest/weekly-contest-305/problems/reachable-nodes-with-restrictions/

//Time & Space Complexity: O(N) O(N)

class Solution {
    int dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Set<Integer> set){
        vis[node] = 1;
        if(set.contains(node)) return 0;
        int c = 0;
        for(int n : adj.get(node)){
            if(vis[n]==0){
                c+=dfs(n, vis, adj, set);
            }
        }
        return 1 + c;
    }
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Set<Integer> set = new HashSet<>();
        for(int i: restricted)
            set.add(i);
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] vis = new int[n];
        return dfs(0, vis, adj, set);
    }
}
