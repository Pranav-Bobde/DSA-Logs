//Link: https://leetcode.com/contest/weekly-contest-299/problems/check-if-matrix-is-x-matrix/

//Time & Space Complexity: O(N) O(N) ; N->No. of elements

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    if(grid[i][j] == 0) return false;
                }else if(j == n-i-1){
                    if(grid[i][j] == 0) return false;
                }else{
                    if(grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}
