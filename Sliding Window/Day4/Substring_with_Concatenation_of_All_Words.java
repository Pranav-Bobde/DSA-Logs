//Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/submissions/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int wordsLen = words.length;
        int k = words[0].length();
        if(wordsLen * k > n) return new ArrayList<>();
        
        HashMap<String, Integer> need = new HashMap<>();
        
        List<Integer> ans = new ArrayList<>();
        
        for(String str : words)
            need.put(str, need.getOrDefault(str, 0) + 1);
        
        for(int i=0; i<= n - (wordsLen * k); i++) {
            HashMap<String, Integer> have = new HashMap<>();
            
            for(int chunkIdx = i; chunkIdx < i + (wordsLen * k); chunkIdx+=k){
                String str = s.substring(chunkIdx, chunkIdx+k);
                if(!need.containsKey(str))
                    break;
                have.put(str, have.getOrDefault(str, 0) + 1);
                
                if(have.get(str) > need.get(str))
                    break;
            }
            
            if(have.equals(need))
                ans.add(i);
        }
        return ans;
    }
}
