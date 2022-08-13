//Link: https://leetcode.com/contest/weekly-contest-299/problems/maximum-score-of-spliced-array/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int s1 = 0, s2 = 0;
        for(int i=0; i<n; i++){
            s1+=nums1[i];
            s2+=nums2[i];
            diff[i] = nums2[i]-nums1[i];
        }
        int curr = 0, max = 0;
        for(int i : diff){
            curr = Math.max(curr+i, i);
            max = Math.max(curr, max);
        }
        s1 = Math.max(s1, s1+max);
        
        for(int i=0; i<n; i++){
            diff[i] = nums1[i]-nums2[i];
        }
        curr = 0; max = 0;
        for(int i : diff){
            curr = Math.max(curr+i, i);
            max = Math.max(curr, max);
        }
        s2 = Math.max(s2, s2+max);
        return Math.max(s1, s2);
    }
}
