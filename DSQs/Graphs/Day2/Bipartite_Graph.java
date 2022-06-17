//Link: 

//Time & Space Complexity: O(V+E) O(V)

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(!bfsCheck(i, color, adj))
                    return false;
            }
        }
        
        return true;
    }
    
    boolean bfsCheck(int i, int[] color, ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(color[it] == -1){
                    q.add(it);
                    color[it] = 1-color[node];
                }else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
