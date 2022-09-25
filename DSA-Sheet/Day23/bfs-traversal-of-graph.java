//Link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

//Time & Space: O(N) O(N)

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] vis = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int n : adj.get(node)){
                if(vis[n]!=1){
                    q.add(n);
                    vis[n] = 1;
                }
            }
        }
        return ans;
    }
}
