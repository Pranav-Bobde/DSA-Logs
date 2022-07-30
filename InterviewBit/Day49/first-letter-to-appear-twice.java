//Link: https://leetcode.com/contest/weekly-contest-303/problems/first-letter-to-appear-twice/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.get(c)!=null)
                return c;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return 'a';
    }
}
