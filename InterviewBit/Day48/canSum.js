//No Link

const canSum = (targetSum, numbers, memo={}) => {
  if(targetSum in memo) return memo[targetSum];
  if(targetSum === 0) return true;
  if(targetSum < 0 ) return false;
  
  for(let num in numbers){
    if(canSum(targetSum-num, numbers, memo) === true){
      memo[targetSum] = true;
      return true;
    }
  }
  memo[targetSum] = false;
  return false;
}
