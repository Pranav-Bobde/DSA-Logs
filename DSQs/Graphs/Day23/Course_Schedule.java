//Link: https://leetcode.com/problems/course-schedule/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Set<Integer> dfsvis = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] arr : prerequisites){
            if(map.get(arr[0])==null)
                map.put(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
        }
        for(int i=0; i<n; i++){
            if(map.get(i)!=null)
                if( dfs(i, dfsvis, map) == false)
                    return false;
            dfsvis.clear();
        }
        
        return true;
    }
    
    boolean dfs(int node, Set<Integer> dfsvis, HashMap<Integer, ArrayList<Integer>> map){
        if(map.get(node)==null) {
            return true;
        }
        dfsvis.add(node);
        for(int n : map.get(node)){
            if(dfsvis.contains(n)){
                return false;
            }
            if(dfs(n, dfsvis, map) == false)
                    return false;
        }
        dfsvis.remove(node);
        map.remove(node);
        return true;
    }
    
}
