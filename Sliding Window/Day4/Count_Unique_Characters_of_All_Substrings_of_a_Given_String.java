//Link: https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int ans = 0;
            
        for(int i=0; i<n; i++)
            map.computeIfAbsent(s.charAt(i), key -> new ArrayList<Integer>()).add(i);
        
        for(List<Integer> indexes : map.values()){
            
            for(int i=0; i<indexes.size(); i++){
                int left = i==0 ? indexes.get(i) + 1 : indexes.get(i) - indexes.get(i-1);
                int right = i==indexes.size()-1 ? s.length() - indexes.get(i) : indexes.get(i+1) - indexes.get(i);
                ans += left * right;
            }
        }
        return ans;
    }
}
