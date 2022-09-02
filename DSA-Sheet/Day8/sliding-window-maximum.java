//Link: https://leetcode.com/problems/sliding-window-maximum/

//Time & Space: O(N) O(1)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int i=0, j=0;
        while(j<n){
            //cal
            while(!q.isEmpty() && q.peekLast() < nums[j]) q.removeLast();
            q.add(nums[j]);
            
            if(j-i+1 < k) j++;
            else if (j-i+1 == k){
                //ans
                ans[idx++] = q.peek();
                //slide
                if(q.peek() == nums[i]){
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
