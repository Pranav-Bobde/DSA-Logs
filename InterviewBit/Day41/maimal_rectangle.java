//Link: https://leetcode.com/problems/maximal-rectangle/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> nsr = new ArrayList<Integer>();
        ArrayList<Integer> nsl = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            if(s.isEmpty()){
                nsl.add(-1);
            }else if(A.get(s.peek()) < A.get(i)){
                nsl.add(s.peek());
            }else if(A.get(s.peek()) >= A.get(i)){
                while(!s.isEmpty() && A.get(s.peek()) >= A.get(i))
                    s.pop();
                if(s.isEmpty())
                    nsl.add(-1);
                else
                    nsl.add(s.peek());
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(s.isEmpty()){
                nsr.add(n);
            }else if(A.get(s.peek()) < A.get(i)){
                nsr.add(s.peek());
            }else if(A.get(s.peek()) >= A.get(i)){
                while(!s.isEmpty() && A.get(s.peek()) >= A.get(i))
                    s.pop();
                if(s.isEmpty())
                    nsr.add(n);
                else
                    nsr.add(s.peek());
            }
            s.push(i);
        }
        Collections.reverse(nsr);
        for(int i = 0; i<n; i++){
            int area = A.get(i) * ( i - nsl.get(i) + nsr.get(i) - i - 1);
            if(area > max)
                max = area;
        }
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int ans = 0;
        for(int i=0; i<r; i++){
            ArrayList<Integer> al = new ArrayList<>();
            for(int j = 0; j<c; j++){
                if(i==0)
                    al.add(matrix[i][j] - '0');
                else{
                    if(matrix[i][j]=='0'){
                        al.add(0);
                    }else{
                        matrix[i][j] = (char)( ((matrix[i][j]-'0') + (matrix[i-1][j] - '0')) + '0');
                        al.add(matrix[i][j] - '0');
                    }
                }
            }
            ans = Math.max(ans, largestRectangleArea(al));
        }
        return ans;
    }
}

//Youtube Common Solution
//Time & Space Complexity: O(N) O(1)

class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i<m; i++)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(mat[i][j] == '0') mat[i][j] = 0;
                else{
                    if(j<n-1)
                        mat[i][j] = (char)(mat[i][j+1] + 1);
                    else
                        mat[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int min_width = mat[i][j];
                for(int k=i; k<m; k++){
                    if(mat[k][j]==0)
                        break;
                    if(mat[k][j] < min_width){
                        min_width = mat[k][j];
                    }
                    ans = Math.max(ans, (k-i+1)*min_width);
                }
            }
        }
        return ans;
    }
}
