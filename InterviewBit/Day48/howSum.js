//No Link

// From O(N^M) -> O(N*M^2)
//Time & Space Complexity: O(N*M2) O(M2)

const howSum = (targetSum, numbers, memo={}) {
  if(targetSum === 0) return [];
  if(targetSum < 0) return null;
  for(let num in numbers){
    const temp = howSum(targetSum-num, numbers, memo);
    if(temp!==null){
      memo[targeSum] = [...temp, num];
      return memo[targetSum];
    }
  }
  memo[targetSum] = null;
  return null;
}
