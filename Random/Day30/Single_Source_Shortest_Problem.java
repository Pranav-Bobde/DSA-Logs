//No Link

//Time & Space Complexity: O(V+E) O(V)

public static int[] dagSSSP(int n, int start, List<Edge> graph){
	int[] topo = toposort(graph, n);
	Integer[] dist = new Integer[n];
	dist[start] = 0;

	for(int i=0; i<n; i++){
		int nodeIndex = topo[i];
		if(dist[nodeIndex] != null){
			List<Edge> neighbours = graph.get(nodeIndex);
			if(neighbours != null){
				for(Edge edge : neighbours){
					int newDist = dist[nodeIndex] + edge.weight;
					if(dist[edge.to] == null) dist[edge.to] = newDist;
					else dist[edge.to] = Math.min(dist[edge.to], newDist);
				}
			}
		}	
	}

	return dist;
}	
