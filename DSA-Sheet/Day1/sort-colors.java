//Link: https://leetcode.com/problems/sort-colors/

//Time & Space: O(N) O(1)

class Solution {
    public void sortColors(int[] ans) {
        int z = 0, o = 0, n = ans.length;
        for(int i : ans){
            if(i==0) z++;
            if(i==1) o++;
        }
        Arrays.fill(ans, 0);
        int i=z;
        while(o-->0){
            ans[i++] = 1;
        }
        while(i<n){
            ans[i++] = 2;
        }
    }
}
