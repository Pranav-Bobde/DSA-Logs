//Link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1

//Time & Space Complexity: O(V+E) O(V)

class Solution
{
    
    boolean bfs(int node, int[] col, ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        col[node] = 1;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int n : adj.get(curr)){
                if(col[n]==-1){
                    col[n] = 1 - col[curr];
                    q.add(n);
                }else if(col[n]==col[curr]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int n, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for(int i=0; i<n; i++){
            if(col[i]==-1){
                if(!bfs(i, col, adj))
                    return false;
            }
        }
        return true;
    }
}
