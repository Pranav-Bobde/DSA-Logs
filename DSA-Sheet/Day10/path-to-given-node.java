//Link: https://www.interviewbit.com/problems/path-to-given-node/

//Time & Space: O(N) O(logN)

public class Solution {
    boolean getPath(TreeNode root, int b, ArrayList<Integer> al){
        if(root == null) return false;
        al.add(root.val);
        if(root.val == b) return true;
        if(getPath(root.left, b, al) || getPath(root.right, b, al)){
            return true;
        }
        al.remove(al.size() - 1);
        return false;
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> al = new ArrayList<>();
        if(A==null) return al;
        getPath(A, B, al);
        return al;
    }
}
