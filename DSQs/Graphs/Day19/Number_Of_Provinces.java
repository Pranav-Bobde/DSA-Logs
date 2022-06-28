//Link: https://leetcode.com/problems/number-of-provinces/

//Time & Space Complexity: O(N) O(N)

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    public int findCircleNum(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = edges.length;
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && edges[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int[] vis = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            // System.out.println(set);
            if(set.contains(i) == false){
                dfs(i, adj);
                count++;
            }
        }
        set.clear();
        return count;
    }
    
    
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj){
        set.add(node);
        for(int n : adj.get(node)){
            if(set.contains(n) == false)
                dfs(n, adj);
        }
    }
}

//Link: https://practice.geeksforgeeks.org/problems/number-of-provinces/1/#

//Time & Space Complexity: O(N) O(N)
//NOTE: Here the HashSet wouldn't pass the test cases. Thus need to use array.
class Solution {
    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int n : adj.get(node)){
            if(vis[n] == false)
                dfs(n, vis, adj);
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = edges.size();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && edges.get(i).get(j) == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }
};

