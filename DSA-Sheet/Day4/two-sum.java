//Link: https://leetcode.com/problems/two-sum/

//Time & Space: O(N) O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int a = -1, b = -1;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                a = map.get(target - nums[i]);
                b = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{a, b};
    }
}
