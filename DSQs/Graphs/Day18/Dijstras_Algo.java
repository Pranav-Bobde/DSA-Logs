//No Link

import java.util.*;

class Node implements Comparator<Node>{
	int v;
	int w;
	Node(){}
	Node(int v, int w){
		this.v = v;
		this.w = w;
	}
	int getV() {return this.v;}
	int getW() {return this.w;}
	@Override
	public int compare(Node n1, Node n2){
		if(n1.w < n2.w){
			return -1;
		}
		if(n1.w > n1.w){
			return 1;
		}
		return 0;
	}
	
}

class Main {
	static void shortestPath(int N, int s, ArrayList<ArrayList<Node>> adj){
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		PriorityQueue<Node> q = new PriorityQueue<Node>(N, new Node());
		q.add(new Node(s, 0));
		while(!q.isEmpty()){
			Node node = q.poll();
			for(Node it : adj.get(node.getV())){
				if(dist[node.getV()] + it.getW() < dist[it.getV()]){
					dist[it.getV()] = dist[node.getV()] + it.getW();
					q.add(new Node(it.getV(), dist[it.getV()]));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}

	public static void main(String[] args){
		int n = 5;
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		for(int i=0; i<n; i++)
			adj.add(new ArrayList<Node>());

		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));

		adj.get(1).add(new Node(2, 4));
		adj.get(2).add(new Node(1, 4));

		adj.get(0).add(new Node(3, 1));
		adj.get(3).add(new Node(0, 1));

		adj.get(3).add(new Node(2, 3));
		adj.get(2).add(new Node(3, 3));

		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));

		adj.get(2).add(new Node(4, 1));
		adj.get(4).add(new Node(2, 1));

		shortestPath(n, 0, adj);
	}
}

