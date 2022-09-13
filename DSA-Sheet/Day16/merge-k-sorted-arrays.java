//Link: https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379?leftPanelTab=0

//Time & Space: O(N) O(K)

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static void merge(ArrayList<Integer> arr){
        ArrayList<Integer> merged = new ArrayList<>();
         
        int i=0, j=0;
        while(i<arr.size() && j<ans.size()){
            if(arr.get(i) <= ans.get(j)){
                merged.add(arr.get(i++));
            }else{
                merged.add(ans.get(j++));
            }
        }
        while(j<ans.size()){
            merged.add(ans.get(j++));
        }
        while(i<arr.size()){
            merged.add(arr.get(i++));
        }
        ans = merged;
    }
    public static void solve(int i, ArrayList<ArrayList<Integer>> arr, int k){
        if(i==k){
            ans = arr.get(i);
            return;
        }
        solve(i+1, arr, k);
        merge(arr.get(i));
    }
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
        if(k==1){
            return kArrays.get(0);
        }
        solve(0, kArrays, k-1);
        return ans;
	}
}
