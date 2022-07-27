//Link: https://practice.geeksforgeeks.org/problems/topological-sort/1

//Time & Space Complexity: O(V+E) O(V)

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ans = new int[V];
        Stack<Integer> s = new Stack<>();
        int[] indegree = new int[V];
        
        for(ArrayList<Integer> al : adj){
            for(int i: al){
                indegree[i]++;
            }
        }
        
        for(int i=0; i<V; i++)
            if(indegree[i] == 0)
                s.push(i);
        
        int idx = 0;
        while(!s.isEmpty()){
            int node = s.pop();
            ans[idx++] = node;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    s.push(it);
            }
            
        }
        
        return ans;
    }
}
