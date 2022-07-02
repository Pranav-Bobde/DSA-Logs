//Link: https://leetcode.com/problems/course-schedule-ii/

//Time & Space Complexity: O(N) O(N)

class Solution {
    ArrayList<Integer> al = new ArrayList<>();
    public int[] findOrder(int n, int[][] prerequisites) {
        if(prerequisites.length == 0){
            int[] ans = new int[n];
            for(int j=0; j<n; j++){
                ans[j] = j;
            }
            return ans;
        }
        Set<Integer> dfsvis = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] arr : prerequisites){
            if(map.get(arr[0])==null)
                map.put(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
        }
        for(int i=0; i<n; i++){
            if(map.get(i)!=null){
                if( dfs(i, dfsvis, map) == false)
                    return new int[]{};
            }
            else{
                if(!al.contains(i))
                    al.add(i);
            }
            dfsvis.clear();
        }
        
        int[] ans = new int[al.size()];
        int idx = 0;
        for(int e: al)
            ans[idx++] = e;
        return ans;
    }
    
    boolean dfs(int node, Set<Integer> dfsvis, HashMap<Integer, ArrayList<Integer>> map){
        if(map.get(node)==null) {
            if(!al.contains(node))
                al.add(node);
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
        if(!al.contains(node))
            al.add(node);
        return true;
    }
}
