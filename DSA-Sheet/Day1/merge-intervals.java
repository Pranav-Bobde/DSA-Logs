//Link: https://leetcode.com/problems/merge-intervals/

//Time & Space: O(NLogN) O(N)

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if(intervals.length==0) return ans.toArray(new int[0][]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int s = intervals[0][0], e = intervals[0][1];
        for(int[] arr : intervals){
            if(arr[0]<=e){
                e = Math.max(e, arr[1]);
            }else{
                ans.add(new int[]{s, e});
                s = arr[0];
                e = arr[1];
            }
        }
        ans.add(new int[]{s, e});
        return ans.toArray(new int[0][]);
    }
}

class Solution {
    class Node implements Comparator<Node>{
        int s, e;
        Node(){}
        Node(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compare(Node n1, Node n2){
            return n1.s - n2.s;
        }
        @Override
        public String toString(){
            return "s: " + s +" e: "+e;
        }
    }
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        for(int[] arr : intervals) pq.add(new Node(arr[0], arr[1]));
        Stack<Node> s = new Stack<>();
        s.push(pq.poll());
        while(!pq.isEmpty()){
            Node prev = s.pop();
            Node curr = pq.poll();
            if(curr.s <= prev.e){
                Node toAdd = new Node(Math.min(prev.s, curr.s), Math.max(prev.e, curr.e));
                s.push(toAdd);
            }else{
                s.push(prev);
                s.push(curr);
            }
        }
        int[][] ans = new int[s.size()][];
        int i = 0;
        for(Node n : s)
        {
            int[] arr = new int[]{n.s, n.e};
            ans[i++] = arr;
        }
        return ans;
    }
}
