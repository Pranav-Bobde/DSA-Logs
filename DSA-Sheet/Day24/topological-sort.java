//Link: https://practice.geeksforgeeks.org/problems/topological-sort/1

//BFS
//Time & Space: O(N) O(N)
class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ind = new int[V];
        for(ArrayList<Integer> al : adj){
            for(int i : al){
                ind[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[V];
        int idx = 0;
        for(int i=0; i<V; i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            for(int n : adj.get(node)){
                ind[n]--;
                if(ind[n]==0) {
                    q.add(n);
                }
            }
        }
        
        return ans;
    }
}

//DFS
//Time & Space: O(N) O(N)
class Solution
{
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, int[] vis){
        vis[node] = 1;
        for(int n : adj.get(node)){
            if(vis[n]==0){
                dfs(n, adj, s, vis);
            }
        }
        s.push(node);
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ind = new int[V];
        for(ArrayList<Integer> al : adj){
            for(int i : al){
                ind[i]++;
            }
        }
        
        int[] vis = new int[V];
        int[] ans = new int[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                dfs(i, adj, s, vis);
            }
        }
        for(int i=0; i<V; i++){
            ans[i] = s.pop();
        }
        return ans;
    }
}
