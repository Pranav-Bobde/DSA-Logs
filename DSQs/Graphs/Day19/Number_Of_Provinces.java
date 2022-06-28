//Link: https://leetcode.com/problems/number-of-provinces/

//Time & Space Complexity: O(N) O(N)
//Optimised - UNION FIND

class Solution {
    int ans;
    public int findCircleNum(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        ans = n;
        for(int i=0; i<n; i++) parent[i] = i;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(i!=j && edges[i][j] == 1){
                    union(i, j, parent, rank);
                }
            }
        }
        
        return ans;
    }
    
    void union(int x, int y, int[] p, int[] r){
        int xR = find(x, p);
        int yR = find(y, p);
        
        if (xR == yR) return;
        
        if(r[xR] < r[yR]){
            p[xR] = yR;
        }else if(r[xR] > r[yR]){
            p[yR] = xR;
        }else{
            p[yR] = xR;
            r[xR]++;
        }
        ans--;
    }
    
    int find(int x, int[] p){
        if(p[x] != x){
            p[x] = find(p[x], p);
        }
        return p[x];
    }
    
}

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

