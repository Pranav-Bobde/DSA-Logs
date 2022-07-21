//Link: https://leetcode.com/problems/count-submatrices-with-all-ones/

//Time & Space Complexity: O(N) O(1)

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=n-2; j>=0; j--)
            {
                if(mat[i][j] != 0) mat[i][j] += mat[i][j+1];
            }
        }
        
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int min = mat[i][j];
                for(int k=i; k<m; k++)
                {
                    if(mat[k][j] == 0) break;
                    min = Math.min(min, mat[k][j]);
                    ans += min;
                }
            }
        }
        
        return ans;
    }
}
