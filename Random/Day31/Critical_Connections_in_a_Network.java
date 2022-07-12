//Link: https://leetcode.com/problems/critical-connections-in-a-network/

//Time & Space Complexity: O(V+E) O(V+E)

class Solution {
    int id = 0;
    void dfs(int at, int parent, boolean[] vis, int[] ids, int[] low, ArrayList<ArrayList<Integer>>adj, List<List<Integer>> ans){
        vis[at] = true;
        low[at] = ids[at] = id++;
        for(int to : adj.get(at)){
            if(to==parent) continue;
            if(!vis[to]){
                dfs(to, at, vis, ids, low, adj, ans);
                low[at] = Math.min(low[at], low[to]);
                if(ids[at] < low[to]){
                    ans.add(new ArrayList<Integer>(Arrays.asList(at, to)));
                }
            }else{
                low[at] = Math.min(low[at], low[to]);
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> graphs) {
        List<List<Integer>> ans = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        for(List<Integer> graph : graphs){
            adj.get(graph.get(0)).add(graph.get(1));
            adj.get(graph.get(1)).add(graph.get(0));
        }
        boolean[] vis = new boolean[n];
        int[] ids = new int[n];
        int[] low = new int[n];
        
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, -1, vis, ids, low, adj, ans);
            }
        }
        id = 0;
        return ans;
    }
}
