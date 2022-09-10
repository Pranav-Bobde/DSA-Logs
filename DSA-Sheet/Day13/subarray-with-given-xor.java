//Link: https://www.interviewbit.com/problems/subarray-with-given-xor/

//Time & Space: O(N) O(N)

public class Solution {
    public int solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans=0;
        int curr = 0;
        for(int i : A){
            curr^=i;
            if(curr == B){
                ans++;
            }
            if(map.containsKey((curr^B))){
                ans+=map.get((curr^B));
            }
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        return ans;
    }
}

