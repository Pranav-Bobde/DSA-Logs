//Link: https://www.interviewbit.com/problems/distribute-candy/

//Time & Space Complexity: O(NlogN) O(N)

public class Solution {
    class Kid implements Comparable<Kid> {
        int rate;
        int idx;
        Kid(){};
        Kid(int r, int i){
            rate = r;
            idx = i;
        }
        @Override
        public int compareTo(Kid k){
            return this.rate - k.rate;
        }
    }
    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Kid> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new Kid(A.get(i), i));
        }
        Collections.sort(al);
        
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for(Kid k : al){
            int kidIdx = k.idx;
            if(kidIdx<n-1 && A.get(kidIdx) > A.get(kidIdx+1)){
                candies[kidIdx] = Math.max(candies[kidIdx], candies[kidIdx+1]+1);
            }
            if(kidIdx>0 && A.get(kidIdx) > A.get(kidIdx-1)){
                candies[kidIdx] = Math.max(candies[kidIdx], candies[kidIdx-1]+1);
            }
        }
        
        int ans = 0;
        for(int c : candies)
            ans+=c;
            
        return ans;
    }
}
