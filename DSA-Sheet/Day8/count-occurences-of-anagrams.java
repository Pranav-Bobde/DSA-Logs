//Link: https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

//Time & Space: O(N) O(M); M-> unique leeters in pattern string

class Solution {

    int search(String p, String s) {
        int n = s.length();
        int k = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int i=0, j=0, count=map.size(), ans=0;
        while(j<n){
            char c = s.charAt(j);
            if(map.get(c)!=null){
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) count--;
            }
            
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                if(count==0){
                    ans++;
                }
                if(map.get(s.charAt(i))!=null){
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    if(map.get(s.charAt(i)) == 1) count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
