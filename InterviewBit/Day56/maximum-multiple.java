//Link: https://practice.geeksforgeeks.org/contest/job-a-thon-exclusive-hiring-challenge-2-for-amazon-alexa/problems/

//Time & Space Complexity: O() O()

class Solution {
    public static long maximumMultiple(int N, int[] A) {
        long ans = Long.MIN_VALUE;
        Arrays.sort(A);
        int cnt = 0;
        for (int i : A) {
            if (i < 0) {
                cnt++;
            }
        }
        if (cnt * 2 == N) {
            for (int i = 0; i < N / 4; i++) {
                int t = A[i];
                A[i] = A[N / 2 - i - 1];
                A[N / 2 - i - 1] = t;
            }
        }
        for (int i = 0; i < N; i++) {
            long op1 = (long)A[i] * A[N - i - 1];
            ans = Math.max(ans, op1);
        }
        return ans;
    }
}
