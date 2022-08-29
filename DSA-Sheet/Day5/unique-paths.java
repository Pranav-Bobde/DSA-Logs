//Link: https://leetcode.com/problems/unique-paths/

//Time & Space: O(M*N) O(M*N)

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int solve(int m, int n){
        if(m==1 || n==1) return 1;
        String key = m+","+n;
        if(map.containsKey(key)){
            return map.get(key);
        }
        map.put(key, solve(m-1, n) + solve(m, n-1));
        return map.get(key);
    }
    public int uniquePaths(int m, int n) {
        return solve(m, n);
    }
}
