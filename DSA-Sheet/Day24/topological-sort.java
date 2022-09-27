//Link: https://practice.geeksforgeeks.org/problems/topological-sort/1

//Time & Space: O(N) O(N)

class Solution
{
    //Function to return list containing vertices in Topological order. 
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
