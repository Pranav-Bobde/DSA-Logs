//Link: https://practice.geeksforgeeks.org/problems/topological-sort/1/

//Time & Space Complexity: O(V+E) O(V)

//Without Stack
class Solution
{
    static int dfs(int node, int idx, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] topo){
        vis[node] = true;
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                idx = dfs(n, idx, vis, adj, topo);
            }
        }
        
        topo[idx] = node;
        return idx-1;
    }
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] vis = new boolean[n];
        int[] topo = new int[n];
        int idx = n-1;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                idx = dfs(i, idx, vis, adj, topo);
            }
        }
        
        return topo;
    }
}

//With Stack
class Solution
{
    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s){
        vis[node] = true;
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                dfs(n, vis, adj, s);
            }
        }
        
        s.push(node);
    }
    
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[n];
        int[] topo = new int[n];
        int idx = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, vis, adj, s);
            }
        }
        while(!s.isEmpty()){
            topo[idx++] = s.pop();
        }
        return topo;
    }
}
