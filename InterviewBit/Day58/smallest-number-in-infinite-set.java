//Link: https://leetcode.com/contest/weekly-contest-301/problems/smallest-number-in-infinite-set/

//Time & Space Complexity: O(N) O(N)

class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for(int i=1; i<=1000; i++){
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(!pq.contains(num)){
            pq.add(num);
        }
    }
}
