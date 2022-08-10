//Link: https://leetcode.com/contest/weekly-contest-300/problems/number-of-people-aware-of-a-secret/

//Time & Space Complexity: O(N) O(N)

//DP Soln
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        long mod = (long) 1e9 + 7;
        long peopleSharing = 0;
        long ans = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            long newPeople = dp[Math.max(i-delay, 0)];
            long peopleForgetting = dp[Math.max(i-forget, 0)];
            peopleSharing += (newPeople - peopleForgetting + mod) % mod;
            dp[i] = peopleSharing;
        }
        
        for(int i=n-forget+1; i<=n; i++){
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }
}

//My Brute Force (nt sure if fully correct?!?!) (TLE!)
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> toAdd = new LinkedList<>();
        Queue<Character> toRemove = new LinkedList<>();
        char max = '1';
        
        while(n-->0){
            if(map.isEmpty()){ 
                map.put(max, 0);
                max++;
                continue;
            }
            
            for(Map.Entry<Character, Integer> e : map.entrySet()){
                map.put(e.getKey(), e.getValue()+1);
            }
            
            for(Map.Entry<Character, Integer> e : map.entrySet()){
                int val = e.getValue();
                if( val == forget){
                    toRemove.add(e.getKey());
                }else if(val >= delay && val < forget){
                    toAdd.add((char)(max+1));
                    max++;
                }
            }
            
            while(!toRemove.isEmpty()){
                map.remove(toRemove.poll());
            }
            
            while(!toAdd.isEmpty()){
                map.put(toAdd.poll(), 0);
            }
        }
        return map.size();
    }
}
