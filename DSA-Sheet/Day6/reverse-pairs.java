//Link: https://leetcode.com/problems/reverse-pairs/

//Time & Space: O(NlogN) O(N)

class Solution {
    public int merge(int[] arr, int s, int mid, int e){
        int c = 0;
        int[] temp = new int[e-s+1];
        int k = s;
        while(k<=e){
            temp[k-s] = arr[k];
            k++;
        }
        
        int i=s, j=mid+1;
        for(; i<=mid; i++){
            while(j<=e && arr[i]>(2*(long)arr[j])){
                j++;
            }
            c+=(j-(mid+1));
        }
        i=s; j=mid+1;
        k = s;
        while(i<=mid && j<=e){
            if(temp[i-s]<=temp[j-s]){
                arr[k++] = temp[(i++)-s];
            }else{
                arr[k++] = temp[(j++)-s];
            }
        }
        while(i<=mid){
            arr[k++] = temp[(i++)-s];
        }
        while(j<=e){
            arr[k++] = temp[(j++)-s];
        }
        return c;
    }
    public int mergeSort(int[] arr, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int c = mergeSort(arr, s, mid);
        c+=mergeSort(arr, mid+1, e);
        c+=merge(arr, s, mid, e);
        return c;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}
