//No Link

class Pair{
  private int v;
  private int weight;
  Pair(int v, int weight){
    this.v = v;
    this.weight = weight;
  }
  int getV(){return this.v;}
  int getWeight(){return this.weight;}
}

class Main {
  
  static void topologicalSort(int node, boolean[] vis, Stack<Integer> s, ArrayList<ArrayList<Pair>> adj){
    vis[node] = true;
    for(Pair it : adj.get(node)){
      if(!vis[it.getV()])
        topologicalSort(it.getV(), vis, s, adj);
    }
    s.push(node);
  }
  
  static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int n){
    Stack<Integer> s = new Stack<>();
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    boolean[] vis = new boolean[n];
    
    for(int i=0; i<n; i++)
      if(vis[i] = false)
        topologicalSort(i, vis, s, adj);
    
    dist[s] = 0;
    
    while(!s.isEmpty()){
      int node = (int) s.pop();
      for(Pair it : adj.get(node)){
        if(dist[it.getV()] > dist[node] + it.getWeight[it]){
          dist[it.getV()] = dist[node] + it.getWeight[it];
        }
      }
    }
    
    for(int i=0; i<n; i++){
      if(dist[i] == Integer.MAX_VALUE){
        System.out.print("INF: ");
      }else{
        System.out.print(dist[i] + " ");
      }
    }
    
  }
  
  public static void main(String[] args){
    int n = 6;
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
    
    for(int i=0; i<n; i++)
      adj.add(new ArrayList<Pair>());
    
    adj.get(0).add(new Pair(1, 2));
    adj.get(0).add(new Pair(4, 1));
    adj.get(1).add(new Pair(2, 3));
    adj.get(2).add(new Pair(3, 6));
    adj.get(4).add(new Pair(2, 2));
    adj.get(4).add(new Pair(5, 4));
    adj.get(5).add(new Pair(3, 1));
    shortestPath(0, adj, n);
  }
}
