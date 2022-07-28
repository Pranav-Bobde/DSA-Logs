//No Link

//Time & Space Complexity: O(V+E) O(V)

void dfs(int node, int parent, int[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>>adj, int timer){
  vis[node] = 1;
  tin[node]=low[node]=timer++;
  for(int n : adj.get(node)){
    if(n==parent) continue;
    if(vis[node]==0){
      dfs(n, node, vis, tin, low, adj, timer);
      low[node] = Math.min(low[node], low[n]);
      if(low[n] > tin[node]){
        System.out.println(n+" "+node);
      }
    }else{
      low[node] = Math.min(low[node], tin[n]);
    }
  }
}

void printBridges(ArrayList<ArrayList<Integer>>adj, int n){
  int[] vis = new int[n];
  int[] tin = new int[n;
  int[] low = new int[n];
  int timer = 0;
  for(int i=0; i<n; i++){
    if(vis[i]==0){
      dfs(i, -1, vis, tin, low, adj, timer);
    }
  }
}
