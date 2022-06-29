//Link: https://structy.net/problems/shortest-path

//Time & Space Complexity: O(N) O(N)

const shortestPath = (edges, nodeA, nodeB) => {
  const adj = buildGraph(edges)
  const q = [[nodeA, 0]]
  const vis = new Set([nodeA])
  while(q.length > 0){
    const [node, dist] = q.shift()
    if (node === nodeB) return dist;
    for( let n of adj[node]){
      if(!vis.has(n)){
        q.push([n, dist+1])
        vis.add(n)
      } 
    }
  }
  return -1;
};

const buildGraph = (edges) => {
  const adj = {}
  
  for(let e of edges){
    const [a, b] = e
    if(!(a in adj)) adj[a] = []
    if(!(b in adj)) adj[b] = []
    adj[a].push(b)
    adj[b].push(a)
  }
  
  return adj
}

module.exports = {
  shortestPath,
};

