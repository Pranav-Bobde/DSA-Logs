//Link: https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

//Time & Space: O(logN) O(N)

class Solution
{
    static long ans = 0;
    public static void merge(long[] arr, int s, int mid, int e){
        long[] temp = new long[e-s+1];
        int k=s;
        while(k<=e){
            temp[k-s] = arr[k];
            k++;
        }
        k = s;
        int i=s, j=mid+1;
        while(i<=mid && j<=e){
            if(temp[i-s]>temp[j-s]){
                ans+=(mid-i+1);
                arr[k++] = temp[(j++)-s];
            }else{
                arr[k++] = temp[(i++)-s];
            }
        }
        while(i<=mid){
            arr[k++] = temp[(i++)-s];
        }
        while(j<=e){
            arr[k++] = temp[(j++)-s];
        }
    }
    
    public static void mergeSort(long[] arr, int s, int e){
        if(s<e){
            int mid = s + (e-s)/2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid+1, e);
            merge(arr, s, mid, e);
        }
    }
    
    static long inversionCount(long arr[], long N)
    {
        mergeSort(arr, 0, (int)N-1);
        long temp = ans;
        ans = 0;
        return temp;
    }
}
