//Link: https://www.interviewbit.com/problems/valid-path/

//Time & Space Complexity: O(N) O(N^2)

public class Solution {
    public String solve(int X, int Y, int N, int R, ArrayList<Integer> A, ArrayList<Integer> B) {
        int[][] matrix = new int[X+1][Y+1];
        boolean[][] vis = new boolean[X+1][Y+1];
        
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        xq.add(0);
        yq.add(0);
        vis[0][0] = true;
        
        
        int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
        int[] dy = new int[]{1, 0, -1, 1, 0, -1, 1, -1};
        while(!xq.isEmpty()){
            int x = xq.poll();
            int y = yq.poll();
            
            if(x == X && y == Y) return "YES";
            
            for(int i=0; i<8; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(newX < 0 || newY < 0 || newX > X || newY > Y || vis[newX][newY])
                    continue;
                    
                boolean validPoint = true;
                for(int j=0; j<N; j++){
                    if(Math.pow(newX - A.get(j), 2) + Math.pow(newY - B.get(j), 2) <= Math.pow(R, 2)){ //Don't use Math.sqrt
                        validPoint = false;
                        break;
                    }
                }
                
                if(!validPoint) continue;
                
                xq.add(newX);
                yq.add(newY);
                vis[newX][newY] = true;
                
            }
        }
        return "NO";
    }
}
