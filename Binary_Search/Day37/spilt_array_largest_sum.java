//Link: https://leetcode.com/problems/split-array-largest-sum/submissions/

//Time & Space Complexity: O(N) O(1)

class Solution {
    boolean canSpilt(int[] arr, int max, int p){
        int c = 0, sum = 0;
        for(int i : arr){
            sum += i;
            if(sum > max){
                c++;
                sum = i;
            }
        }
        return c+1 <= p;
    }
    
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int s = nums[0], e = 0;
        for(int i: nums){
            s = Math.max(s, i);
            e += i;
        }
        int ans = e;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(canSpilt(nums, mid, m)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}
