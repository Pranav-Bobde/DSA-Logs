//Link: https://www.interviewbit.com/problems/maximum-sum-combinations/

//Time & Space: O(NlogN) O(C)

public class Solution {
    class Node implements Comparator<Node>{
        int val, i, j;
        Node(){}
        Node(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
        public int compare(Node n1, Node n2){
            return n2.val - n1.val;
        }
    }
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int[] ans = new int[C];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        Set<String> set = new HashSet<>();
        int idx = 0;
        pq.add(new Node(A[n-1] + B[n-1], n-1, n-1));
        set.add((n-1)+","+(n-1));
        while(idx!=C){
            Node node = pq.poll();
            ans[idx] = node.val;
            int i = node.i, j = node.j;
            String ij1 = (i)+","+(j-1);
            if(!set.contains(ij1)){
                pq.add(new Node(A[i] + B[j-1], i, j-1));
                set.add(ij1);
            }
            
            String ij2 = (i-1)+","+(j);
            if(!set.contains(ij2)){
                pq.add(new Node(A[i-1] + B[j], i-1, j));
                set.add(ij2);
            }
            idx++;
        }
        return ans;
    }
}
