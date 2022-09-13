//Link: https://leetcode.com/problems/top-k-frequent-elements/

//Time & Space: O(NlogN) O(N)

class Solution {
    class Node implements Comparator<Node>{
        int val, f;
        Node(){};
        Node(int val, int f){
            this.val = val;
            this.f = f;
        }
        public int compare(Node n1, Node n2){
            return n2.f - n1.f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new Node(e.getKey(), e.getValue()));
        }
        int[] ans = new int[k];
        int idx = 0;
        while(idx!=k){
            ans[idx++] = pq.poll().val;
        }
        return ans;
    }
}
