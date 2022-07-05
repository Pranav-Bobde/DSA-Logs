//Link: https://www.interviewbit.com/problems/cycle-in-undirected-graph/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    int dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int n : adj.get(node)){
            if(!vis[n]){
                if(dfs(n, node, vis, adj) == 1)
                    return 1;
            }else if(n != parent){
                return 1;
            }
        }
        return 0;
    }
    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<=A; i++)
            adj.add(new ArrayList<Integer>());
            
        for(ArrayList<Integer> al : B){
            adj.get(al.get(0)).add(al.get(1));
            adj.get(al.get(1)).add(al.get(0));
        }
        
        boolean[] vis = new boolean[A+1];
        
        for(int i=1; i<=A; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj) == 1)
                    return 1;
            }
        }
        
        return 0;
    }
