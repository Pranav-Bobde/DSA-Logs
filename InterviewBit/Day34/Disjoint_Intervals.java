//Link: https://www.interviewbit.com/problems/disjoint-intervals/

//Time & Space Complexity: O(NlogN) O(1)

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A, new Comparator <ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
                return a1.get(1).compareTo(a2.get(1));
            }
        } );
        
        
        int ans = 1;
        int prevs = A.get(0).get(0);
        int preve = A.get(0).get(1);
        
        for(ArrayList<Integer> al : A){
            int s = al.get(0);
            int e = al.get(1);
            if(preve < s){
                prevs = s;
                preve = e;
                ans++;
            }
        }
        
        return ans;
    }
}
