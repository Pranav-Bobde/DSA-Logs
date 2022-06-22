//Link: https://practice.geeksforgeeks.org/problems/topological-sort/1/

//Time & Space Complexity: O(N + E) O(N)

//DFS
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

//BFS (Kahn's Algorithm)

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ans = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        
        for(ArrayList<Integer> al : adj){
            for(int i: al){
                indegree[i]++;
            }
        }
        
        for(int i=0; i<V; i++)
            if(indegree[i] == 0)
                q.add(i);
        
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
            
        }
        
        return ans;
    }
}
