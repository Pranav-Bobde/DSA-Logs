//Link: https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

//Time & Space Complexity: O(NLogN) O(N)

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long cost = 0;
        for(long i : arr)
            pq.add(i);
            
        while(pq.size()>=2){
            long a = pq.poll(), b = pq.poll();
            cost+=a+b;
            pq.add(a+b);
        }
        return cost;
    }
}
