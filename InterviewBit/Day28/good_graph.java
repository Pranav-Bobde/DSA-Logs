//Link: https://www.interviewbit.com/problems/good-graph/

//Time & Space Complexity: 

public class Solution {
    
    int dfs(int node, boolean[] vis, ArrayList<Integer> A){
        if(A.get(node) == 1){
            return 0;
        }
        
        if(vis[node]){
            A.set(node, 1);
            return 1;
        }
        
        vis[node] = true;
        int res = dfs(A.get(node)-1, vis, A);
        A.set(node, 1);
        return res;
    }
    
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(dfs(i, vis, A) == 1)
                    count++;
            }
        }
        return count;
    }
}
