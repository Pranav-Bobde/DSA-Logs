//Link: https://leetcode.com/problems/pascals-triangle/

//Time & Space Complexity: O(N^2) O(N^2)

class Solution {
    public List<List<Integer>> generate(int x) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> prev = null;
        for(int i=0; i<x; i++){
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0||j==i){
                    al.add(1);
                }else{
                    al.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev = al;
            ans.add(al);
        }
        return ans;
    }
}

class Solution {
    public List<List<Integer>> generate(int x) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        ans.add(al);
        if(x==1) return ans;
        al = new ArrayList<>();
        al.add(1);
        al.add(1);
        ans.add(al);
        if(x==2) return ans;
        while(x-->2){
            ArrayList<Integer> al1 = new ArrayList<>();
            al1.add(1);
            List<Integer> prev = ans.get(ans.size()-1);
            for(int i=1; i<prev.size(); i++){
                al1.add(prev.get(i-1) + prev.get(i));
            }
            al1.add(1);
            ans.add(al1);
        }
        return ans;
    }
}
