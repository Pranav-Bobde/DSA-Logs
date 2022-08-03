//Link: https://leetcode.com/contest/weekly-contest-302/problems/minimum-deletions-to-make-array-divisible/

//Time & Space Complexity: O(NLogN) O(1)

class Solution {
    int findGcd(int[] arr){
        int x = arr[0];
        for(int i=1; i<arr.length; i++){
            int n = arr[i];
            while(n>0){
                int temp = x % n;
                x = n;
                n = temp;
            }
        }
        return x;
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int x = findGcd(numsDivide);
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(x%nums[i]==0){
                return i;
            }
        }
        return -1;
    }
}
