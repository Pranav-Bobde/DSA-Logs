//Link: https://leetcode.com/problems/set-matrix-zeroes/

//Time & Space Complexity: O(M*N) O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    if(i>0)
                        matrix[i][0]=0;
                    else
                        row = 0;
                }
            }
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(
                    matrix[0][j]==0 ||
                    matrix[i][0]==0
                ){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0]==0){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
        if(row == 0){
            Arrays.fill(matrix[0], 0);
        }
        
    }
}

//Time & Space Complexity: O(M*N) O(M+N)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(
                    rows[i]==1 ||
                    cols[j]==1
                ){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
