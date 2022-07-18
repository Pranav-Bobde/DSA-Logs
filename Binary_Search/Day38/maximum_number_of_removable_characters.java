//https://leetcode.com/problems/maximum-number-of-removable-characters/

//Time & Space Complexity: O(NlogK) O(K)

class Solution {
    boolean isSubsequence(String s, String p, Set<Integer> set){
        int i1 = 0, i2 = 0;
        while(i1<s.length() && i2<p.length()){
            if(set.contains(i1) || s.charAt(i1)  != p.charAt(i2)){
                i1++;
            }else{
                i1++;
                i2++;
            }
        }
        return i2 == p.length();
    }
    
    public int maximumRemovals(String str, String p, int[] r) {
        int s = 0, e = r.length-1, ans = 0;
        while(s<=e){
            int mid = s + (e-s)/2;
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<=mid; i++){
                set.add(r[i]);
            }
            if(isSubsequence(str, p, set)){
                ans = Math.max(ans, mid+1);
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
}
