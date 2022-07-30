//Link: https://leetcode.com/contest/weekly-contest-303/problems/equal-row-and-column-pairs/

//Time & Space Complexity: O(N^2) O(N)

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, String> rmap = new HashMap<>();
        HashMap<Integer, String> cmap = new HashMap<>();
        
        for(int r=0; r<n; r++){
            rmap.put(r, "");
            for(int c=0; c<n; c++){
                rmap.put(r, rmap.get(r) + ("," + grid[r][c]) );
            }
        }
        
        for(int c=0; c<n; c++){
            cmap.put(c, "");
            for(int r=0; r<n; r++){
                cmap.put(c, cmap.get(c) + ("," + grid[r][c]) );
            }
        }
        int c = 0;
        for(Map.Entry<Integer, String> re : rmap.entrySet()){
            for(Map.Entry<Integer, String> ce : cmap.entrySet()){
                if(re.getValue().equals(ce.getValue())){
                    c++;
                }
            }
        }
        return c;
    }
}
