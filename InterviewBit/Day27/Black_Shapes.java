//Link: https://www.interviewbit.com/problems/black-shapes/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    boolean[][] vis;
    int count = 0;
    int di[] = new int[]{1, -1, 0, 0};
    int dj[] = new int[]{0, 0, 1, -1};
    ArrayList<String> a;
    
    public void dfs(int i, int j, int m, int n){
        vis[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];
            if(isValid(ii, jj, m, n) && !vis[ii][jj]) 
                dfs(ii, jj, m, n);
        }
    }
    
    public boolean isValid(int i, int j, int m, int n) {
        if(i < 0 || i >= m ||
           j < 0 || j >= n)
            return false;
        if(a.get(i).charAt(j) != 'X')
            return false;
        
        return true;
               
    }
    
    public int black(ArrayList<String> a) {
        if(a == null || a.size() == 0)
            return count;
            
        int m = a.size();
        int n = a.get(0).length();
        
        vis = new boolean[m][n];
        this.a = a;
        
        for(int i = 0; i < m; i++){
            for(int j = 0;  j < n; j++){
                if(vis[i][j] == false && a.get(i).charAt(j) == 'X'){
                   dfs(i, j, m, n);
                   count++;
                }
            }
        }
        
        return count;
    }
}
