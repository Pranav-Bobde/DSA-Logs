//Link: https://structy.net/problems/island-count

//Time & Space Complexity: O(N) O(N)

const islandCount = (grid) => {
  const vis = new Set()
  let count = 0; 
  for(let i=0; i<grid.length; i+=1){
    for(let j=0; j<grid[0].length; j+=1){
      if(explore(i, j, grid, vis) == true){
        count+=1
      }
    }
  }
  return count;
};

const explore = (i, j, grid, vis) => {
  const rowBound = 0<=i && i<grid.length;
  const colBound = 0<=j && j<grid[0].length;
  if(!rowBound || !colBound) return false;
  if(grid[i][j]=='W') return false;
  const pos = i + ',' + j;
  if(vis.has(pos)) return false;
  vis.add(pos);
  explore(i, j+1, grid, vis);
  explore(i, j-1, grid, vis);
  explore(i+1, j, grid, vis);
  explore(i-1, j, grid, vis);
  return true;
}

module.exports = {
  islandCount,
};

