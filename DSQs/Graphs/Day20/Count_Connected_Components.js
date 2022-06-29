//Link: https://structy.net/problems/connected-components-count

//Time & Space Complexity: O(N) O(N)

const connectedComponentsCount = (graph) => {
  const vis = new Set();
  let count = 0;
  for(let i in graph){
    if(!vis.has(i)){
      explore(i, vis, graph);
      count++;
    }
  }
  return count; 
};

const explore = (i, vis, adj) => {
  vis.add(String(i));
  for(let n of adj[i]){
    if(!vis.has(String(n))){
      explore(n, vis, adj)
    }
  }
}

module.exports = {
  connectedComponentsCount,
};
