//Link: https://leetcode.com/problems/reverse-words-in-a-string/

//Time & Space: O(N) O(N)

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        if(n==0) return "";
        StringBuilder sb = new StringBuilder();
        int i=n-1, j=n-1;
        while(j>=0){
            char c = s.charAt(j);
            if(c==' '){
                sb.append(s.substring(j+1, i+1) + " ");
                while(j>0 && s.charAt(j-1)==' ') j--;
                j--;
                i=j;
            }else{
                j--;
            }
            if(i!=-1 && j==-1){
                sb.append(s.substring(j+1, i+1));
            }
        }
        
        return sb.toString();
    }
}
