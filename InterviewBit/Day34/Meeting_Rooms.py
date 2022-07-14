#Link: https://www.interviewbit.com/problems/meeting-rooms/

#Time & Space Complexity: O(N) O(N2)

class Solution:
    # @param A : list of list of integers
    # @return an integer
    def solve(self, A):
        data = []
        for s, e in A:
            data.append((s, +1))
            data.append((e, -1))
            
        data.sort()
        
        curr = 0
        ans = 0
        
        for _, v in data:
            curr+=v
            ans = max(ans, curr)
        
        return ans
