//Link: https://leetcode.com/problems/rotting-oranges/

//Time & Space: O(M*N) O(M*N)

class Solution {

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int[] d1 = new int[]{0, 0, 1, -1};
        int[] d2 = new int[]{1, -1, 0, 0};
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q1.add(i);
                    q2.add(j);
                }
            }
        }
        
        q1.add(-1);
        q2.add(-1);
        int prev = -1;
        while(!q1.isEmpty()){
            int i = q1.poll();
            int j = q2.poll();
            if(i==-1 && j==-1){
                if(prev == 1){
                    ans++;
                    prev = -1;
                }else{
                    break;
                }
                q1.add(-1);
                q2.add(-1);
            }else{
                for(int k=0; k<4; k++){
                    int i2 = i + d1[k];
                    int j2 = j + d2[k];
                    if(i2<0 || j2<0 || i2>=m || j2>=n){
                        continue;
                    }
                    if(grid[i2][j2]==1){
                        if(prev==-1){
                            prev = 1;
                        }
                        grid[i2][j2] = 2;
                        q1.add(i2);
                        q2.add(j2);
                        fresh--;
                    }
                }
            }
        }
        
        return fresh==0 ? ans : -1;
    }
}
