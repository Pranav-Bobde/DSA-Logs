//Link: https://practice.geeksforgeeks.org/problems/topological-sort/1/

//Time & Space Complexity: O(N) O(N)

class Solution
{
    static void topo(int node, Stack<Integer> s, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it]==0)
                topo(it, s, vis, adj);
        }
        s.push(node);
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis = new int[V];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                topo(i, s, vis, adj);
            }
        }
        int[] ans = new int[V];
        for(int i=0; i<V; i++){
            ans[i] = s.pop();
        }
        return ans;
    }
}
