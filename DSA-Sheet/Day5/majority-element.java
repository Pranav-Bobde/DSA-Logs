//Link: https://leetcode.com/problems/majority-element/

//Time & Space: O(N) O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int ans = -1, c = 0;
        for(int i: nums){
            if(c==0){
                ans = i;
                c = 1;
            }else{
                if(ans == i){
                    c++;
                }else{
                    c--;
                }
            }
        }
        return ans;
    }
}
