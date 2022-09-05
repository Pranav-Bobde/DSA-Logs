//Link: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

//Time & Space: O(N) O(N)

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int ans = -1;
        while(j<n){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.size() < k) j++;
            else if(map.size() == k){
                ans = Math.max(ans, j-i+1);
                j++;
            }else if(map.size() > k){
                while(map.size() > k){
                    char rc = s.charAt(i);
                    map.put(rc, map.getOrDefault(rc, 0) - 1);
                    if(map.get(rc) == 0){
                        map.remove(rc);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
