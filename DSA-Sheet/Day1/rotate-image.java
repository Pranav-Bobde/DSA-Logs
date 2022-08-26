//Link: https://leetcode.com/problems/rotate-image/

//Time & Space: O(N^2) O(1)

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=i; j<n; j++){
                swap(matrix, i, j);
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    void swap(int[][] m, int i, int j){
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
    }
}
