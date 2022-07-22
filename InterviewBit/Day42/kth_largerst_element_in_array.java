//Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

//Time & Space Complexity: O(NLogK) O(K)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
