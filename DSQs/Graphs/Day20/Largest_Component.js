//Link: https://structy.net/problems/largest-component

//Time & Space Complexity: O(N) O(N)

const largestComponent = (graph) => {
  const vis = new Set();
  let max = 0;
  for(let i in graph){
    if(!vis.has(i)){
      const res = explore(i, vis, graph);
      if(res>max)
        max = res
    }
  }
  return max;  
};

const explore = (i, vis, adj) => {
  vis.add(i);
  let size = 1;
  for(let n of adj[i]){
    if(!vis.has(n)){
      size+=explore(n, vis, adj)
    }
  }
  return size;
}

module.exports = {
  largestComponent,
};

