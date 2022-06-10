// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

//Time Complexity: O(N)
//Space Complexity: O(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        int i = 0, j = 0, ans = 0;
        HashSet<Character> set = new HashSet<>();
        while(j<n){
            char c = s.charAt(j);
            if(!set.contains(c)){
                if(j-i+1 > ans)
                    ans = j-i+1;
                set.add(c);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}


// or

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        
        while(j<n){
            char c = s.charAt(j);
            if(map.get(c) != null){
                map.remove(s.charAt(i));
                i++;
            }else{
                map.put(c, 1);
                j++;    
            }
            ans = Math.max(ans, j-i);
        }
        
        return ans;
    }
}


