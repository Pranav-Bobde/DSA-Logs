//Link: https://leetcode.com/problems/majority-element-ii/

//Time & Space: O(N) O(N)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()>n/3){
                ans.add(e.getKey());
            }
        }
        return ans;
    }
}
