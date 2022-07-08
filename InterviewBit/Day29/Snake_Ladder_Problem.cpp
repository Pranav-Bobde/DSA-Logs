//Link: https://www.interviewbit.com/problems/snake-ladder-problem/

//Time & Space Complexity: 

public class Solution {
    ArrayList<ArrayList<Integer>> snake;
    ArrayList<ArrayList<Integer>> ladder;
    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        boolean visited[]=new boolean[101];
        snake=A;
        ladder=B;
        for(int i=0;i<=100;i++)graph.add(new ArrayList<>());
        
        for(int i=1;i<=100;i++){
            for(int j=1;j<=6;j++){
                int dest=i+j;
                if(dest<=100){
                    int sl=getSnakeOrLadder(dest);
                    if(sl!=-1){
                        graph.get(i).add(sl);
                    }
                    else{
                        graph.get(i).add(dest);
                    }
                }
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        int ans=0;
        
        while(q.size()!=0){
            int currDepthPositions=q.size();
            for(int i=0;i<currDepthPositions;i++){
                int curr=q.poll();
                if(curr==100)return ans;
                for(int j=0;j<graph.get(curr).size();j++){
                    if(!visited[graph.get(curr).get(j)]){
                        q.add(graph.get(curr).get(j));
                        visited[graph.get(curr).get(j)]=true;
                    }
                }
                
            }
            ans++;
            
            
        }
        return -1;
        
    }
    
    int getSnakeOrLadder(int x){
        for(int i=0;i<snake.size();i++){
            if(snake.get(i).get(0)==x){
                return snake.get(i).get(1);
            }
        }
        for(int i=0;i<ladder.size();i++){
            if(ladder.get(i).get(0)==x){
                return ladder.get(i).get(1);
            }
        }
        return -1;
    }
}

