//Link: https://leetcode.com/problems/next-greater-element-ii/

//Time & Space: O(N) O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        int[] temp = new int[2*n];
        int[] arr = new int[2*n];
        for(int i=n; i<2*n; i++){
            arr[i] = arr[i-n] = nums[i-n];
        }
        
        for(int i=2*n-1; i>=0; i--){
            int num = arr[i];
            while(!s.isEmpty() && num >= s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                temp[i] = -1;
            }else{
                temp[i] = s.peek();   
            }
            
            s.push(num);
        }
        for(int i=0; i<n; i++){
            ans[i] = temp[i];
        }
        return ans;
    }
}
