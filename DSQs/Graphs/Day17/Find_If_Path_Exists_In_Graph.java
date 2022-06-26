//Link: https://leetcode.com/problems/find-if-path-exists-in-graph/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
            
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(vis[it] == 0 && it == destination)
                    return true;
                if(vis[it] == 0){
                    q.add(it);
                    vis[it] = 1;
                }
            }
        }
        
        return vis[destination] == 1;
    }
}
