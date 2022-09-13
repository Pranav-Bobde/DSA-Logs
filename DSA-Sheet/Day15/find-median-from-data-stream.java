//Link: https://leetcode.com/problems/find-median-from-data-stream/

//Time & Space: O(NlogN) O(N)

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if(left.isEmpty() || left.peek() >= num){
            left.add(num);
        }else{
            right.add(num);
        }

        if(left.size() > right.size() + 1){
            right.add(left.poll());
        }else if(left.size() < right.size()){
            left.add(right.poll());
        }
        
    }
    
    public double findMedian() {
        if(left.size() == right.size())
            return (left.peek()/2.0 + right.peek()/2.0);
        return left.peek();
    }
}
