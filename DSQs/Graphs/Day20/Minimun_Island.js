//Link: 

//Time & Space Complexity: O(N) O(N)

const minimumIsland = (grid) => {
  const vis = new Set()
  let min = Number.MAX_SAFE_INTEGER; 
  for(let i=0; i<grid.length; i+=1){
    for(let j=0; j<grid[0].length; j+=1){
        const res = explore(i, j, grid, vis);
        if(res!=0 && res < min)
          min = res;
    }
  }
  return min;
};


const explore = (i, j, grid, vis) => {
  const rowBound = 0<=i && i<grid.length;
  const colBound = 0<=j && j<grid[0].length;
  if(!rowBound || !colBound) return 0;
  if(grid[i][j]=='W') return 0;
  const pos = i + ',' + j;
  if(vis.has(pos)) return 0;
  vis.add(pos);
  let size = 1;
  size += explore(i, j+1, grid, vis);
  size += explore(i, j-1, grid, vis);
  size += explore(i+1, j, grid, vis);
  size += explore(i-1, j, grid, vis);
  return size;
}



module.exports = {
  minimumIsland,
};
