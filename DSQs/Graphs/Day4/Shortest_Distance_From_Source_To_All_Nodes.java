// No Link

//Time & Space Complexity: O(N+E) O(N)

int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src,  int N){
  int[] dist = new int[N];
  Arrays.fill(dist, Integer.MAX_VALUE);
  Queue<Integer> q = new LinkedList<>();
  q.add(src);
  dist[src]=0;
  
  while(!q.isEmpty()){
    int node = q.poll();
    for(int it : adj.get(node)){
      if(dist[node] + 1 < dist[it]){
        dist[it] = dist[node] + 1;
        q.add(it);
      }
    }
  }
  
  return dist;
}
