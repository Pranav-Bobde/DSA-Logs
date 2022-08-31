//Link: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

//Time & Space: O(N) O(K)

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int i=0, j=0, idx=0;
        long[] ans = new long[N-K+1];
        Queue<Long> q = new LinkedList<>();
        while(j<N){
            //cal
            if(A[j]<0) q.add(A[j]);
            
            //check window size
            if(j-i+1 < K) j++;
            else if(j-i+1 == K){
                if(q.isEmpty()) ans[idx++] = 0;
                else{
                    //cal ans
                    ans[idx++] = q.peek();
                    
                    //remove last element
                    if(A[i]==q.peek()) q.poll();
                }
                //slide window
                i++;
                j++;
            }
        }
        return ans;
    }
}
