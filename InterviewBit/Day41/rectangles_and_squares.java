//Link: https://practice.geeksforgeeks.org/contest/job-a-thon-11-hiring-challenge/problems/#

//Time & Space Complexity: O(log(min(a, b)) or O(N),  O(N)

class Solution {
    public static int minimumMoves(int A, int B) {
        if(A == B)
            return 1;
            
        int c = 0;
        while(A != 1 || B != 1) {
            if(A > B) {
                A = A-B;
                c++;
            } else if(B > A) {
                B = B-A;
                c++;
            } else {
                return 1+c;
            }
        }
        return Math.max(A,B)+c;
    }
}

//
class Solution {
    static void f(int a, int b, int[] ans){
        if(a==b){
            ans[0]+=1;
            return;
        }
        if(a==1){
            ans[0]+=b;
            return;
        }
        if(b==1){
            ans[0]+=a;
            return;
        }
        if(a%b==0){
            ans[0]+=a/b;
            return;
        }else if(b%a==0){
            ans[0]+=b/a;
            return; 
        }
        if(b>a){
            ans[0]+=b/a;
            f(a, b%a, ans);
        }else if(a>b){
            ans[0]+=a/b;
            f(a%b, b, ans);
        }
    }
    public static int minimumMoves(int a, int b) {
        int[] ans = new int[]{0};
        f(a, b, ans);
        return ans[0];
    }
}
