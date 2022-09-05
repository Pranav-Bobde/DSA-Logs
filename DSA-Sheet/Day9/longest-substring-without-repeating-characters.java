//Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

//Time & Space: O(N) O(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int ans = 0;
        while(j<n){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.size() == (j-i+1)){
                ans = Math.max(ans, j-i+1);
                j++;
            }else if(map.size() < (j-i+1)){
                while(map.size() < (j-i+1)){
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
