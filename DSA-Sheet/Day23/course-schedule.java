//Link: https://leetcode.com/problems/course-schedule/

//Time & Space: O(N) O(N)

class Solution {
    public boolean canFinish(int n, int[][] pre) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] arr : pre){
            adj.get(arr[0]).add(arr[1]);
        }
        
        List<Integer> list = new ArrayList<>();
        int[] inD = new int[n];
        for(ArrayList<Integer> ad : adj){
            for(int i : ad){
                inD[i]++;
            }
        }
      
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inD[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            for(int ad : adj.get(node)){
                inD[ad]--;
                if(inD[ad]==0) q.add(ad);
            }
        }
        if(list.size() == n) return true;
        return false;
    }
}
