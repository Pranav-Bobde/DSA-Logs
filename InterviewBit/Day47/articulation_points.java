//No Link

//Time & Space Complexity: O(V+E) O(V)

void dfs(int node, int parent, int[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>>adj, int timer, int[] isAP){
  vis[node] = 1;
  tin[node]=low[node]=timer++;
  for(int n : adj.get(node)){
    if(n==parent) continue;
    if(vis[n]==0){
      dfs(n, node, vis, tin, low, adj, timer, isAP);
      low[node] = Math.min(low[node], low[n]);
      if(low[n] >= tin[node] && parent!=-1){
        isAP[node]=1;
      }
      child++;
    }else{
      low[node] = Math.min(low[node], tin[n]);
    }
  }
  if(parent==-1 && child>1)
    isAP[node] = 1;
}

void printBridges(ArrayList<ArrayList<Integer>>adj, int n){
  int[] vis = new int[n];
  int[] tin = new int[n;
  int[] low = new int[n];
  int[] isAP = new int[n];
  int timer = 0;
  for(int i=0; i<n; i++){
    if(vis[i]==0){
      dfs(i, -1, vis, tin, low, adj, timer, isAP);
    }
  }
                      
  for(int i=0; i<n; i++){
    if(isAP[i]==1)
      System.out.println(i);
  }
                      
}
