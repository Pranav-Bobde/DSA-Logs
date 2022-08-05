//Link: https://practice.geeksforgeeks.org/contest/job-a-thon-exclusive-hiring-challenge-2-for-amazon-alexa/problems/

//Time & Space Complexity: O(N) O(N) ; N -> max in arr

class Solution {
    static int kthMex(int n, int k, int arr[]) {
        int max = -1;
        Map<Integer, Integer> is = new HashMap<>();
        for(int i:arr){
            max = Math.max(max, i);
            is.put(i, is.getOrDefault(i, 0)+1);
        }
            
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<=max; i++){
            if(is.get(i)==null && pq.size() <= k){
                pq.add(i);
            }
            if(pq.size() == k) break;
        }
        if(pq.size() < k){
            return max + (k-pq.size());
        } 
        for(int i=1; i<k; i++)
            pq.poll();
            
        return pq.poll();
    }
}
