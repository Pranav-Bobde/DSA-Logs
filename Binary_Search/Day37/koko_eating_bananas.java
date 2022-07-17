//Link: https://leetcode.com/problems/koko-eating-bananas/

//Time & Space Complexity: O(NlogN) O(1)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int s = 1, e = piles[0];
        for(int i : piles){
            e = Math.max(e, i);
        }
        int ans = e;
        while(s<=e){
            int mid = s + (e-s)/2;
            int count = 0;
            for(int i: piles)
                count+= Math.ceil(((double)i)/mid);
            if(count <= h){
                ans = Math.min(ans, mid);
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}
