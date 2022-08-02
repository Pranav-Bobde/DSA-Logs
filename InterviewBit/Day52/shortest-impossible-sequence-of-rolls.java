//Link: https://leetcode.com/contest/biweekly-contest-83/problems/shortest-impossible-sequence-of-rolls/

//Time & Space Complexity: O() O()

class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int n = rolls.length;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!set.contains(rolls[i])){
                set.add(rolls[i]);
                if(set.size() == k){
                    set.clear();
                    ans++;
                }
            }
        }
        return ans+1;
    }
}
