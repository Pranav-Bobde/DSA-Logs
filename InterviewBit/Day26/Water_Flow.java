//Link: https://www.interviewbit.com/problems/water-flow/

//Time & Space Complexity: O(N) O(N*M)

//BFS
public class Solution {
    
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    void bfs(Queue<Pair> q, boolean[][] vis, int row, int col, ArrayList<ArrayList<Integer>> matrix){
        while(!q.isEmpty()){
            int x = q.peek().a;
            int y = q.peek().b;
            q.poll();
            
            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(newX<0 || newY<0 || newX >= row || newY >= col || vis[newX][newY])
                    continue;
                    
                if(matrix.get(x).get(y) <= matrix.get(newX).get(newY)){
                    q.add(new Pair(newX, newY));
                    vis[newX][newY] = true;
                }
            }
        }
    }
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        
        if(N==0) return 0;
        
        Queue<Pair> blueq = new LinkedList<>();
        Queue<Pair> redq = new LinkedList<>();
        
        boolean[][] bluevis = new boolean[N][M];
        boolean[][] redvis = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i==0 || j==0){
                    blueq.add(new Pair(i, j));
                    bluevis[i][j] = true;
                }
                if(i==N-1 || j==M-1){
                    redq.add(new Pair(i, j));
                    redvis[i][j] = true;
                }
            }
        }
        
        bfs(blueq, bluevis, N, M, A);
        bfs(redq, redvis, N, M, A);
        
        int ans = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(bluevis[i][j] && redvis[i][j]){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
