// Link: https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String p, String s) {
        int n = s.length();
        
        if(n < p.length()) return false;
        
        int[] pf = new int[27];
        int[] sf = new int[27];
        
        for(int i=0; i<p.length(); i++){
            pf[p.charAt(i)-'a']++;
            sf[s.charAt(i)-'a']++;
        }
        
        if(Arrays.equals(pf,sf)) return true;
        
        for(int i=p.length(); i<s.length(); i++){
            sf[s.charAt(i)-'a']++;
            sf[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(pf,sf)) return true;
        }
        
        return false;
    }
}
