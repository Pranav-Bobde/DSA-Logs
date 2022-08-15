//Link: https://leetcode.com/contest/weekly-contest-305/problems/number-of-arithmetic-triplets/

//Time & Space Complexity: O() O()

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        for(int i=n-1; i>=0; i--){
            int curr = nums[i];
            int c = 1;
            while(c<3){
                if(set.contains(curr - diff)){
                    curr = curr - diff;
                    c++;
                }else{
                    break;
                }
            }
            if(c==3)
                ans++;
        }
        return ans;
    }
}
