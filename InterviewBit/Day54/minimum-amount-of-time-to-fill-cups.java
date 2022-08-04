//Link: https://leetcode.com/contest/weekly-contest-301/problems/minimum-amount-of-time-to-fill-cups/

//Time & Space Complexity: O(N) O(1) //N -> max ele of arr

class Solution {
    public int fillCups(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: arr)
            if(i!=0) pq.add(i);
        
        int ans = 0;
        if(pq.isEmpty()) return ans;
        if(pq.size() < 3) return pq.poll();
        while(!pq.isEmpty()){
            if(pq.size() < 3){
                ans += pq.poll();
                break;
            }
            int l = pq.poll()-1, s = pq.poll()-1;
            ans++;
            if(l!=0)
                pq.add(l);
            if(s!=0)
                pq.add(s);       
        }
        return ans;
    }
}
