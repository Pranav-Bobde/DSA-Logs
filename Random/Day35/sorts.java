import java.util.*;
public class Main
{
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //bubble sort - O(N2)
    static void bubble(int[] arr){
        int n = arr.length;
        int i = n-1;
        while(i>0){
            if(arr[i] < arr[i-1]){
                swap(arr, i, i-1);
            }else{
                break;
            }
            i--;
        }
    }
    
    static void bubbleSort(int[] arr){
        int i = 0;
        int n = arr.length;
        while(i<n-1){
            bubble(arr);
            i++;
        }
    }
    
    //selection sort - O(N2)
    static int findSmallest(int[] arr, int s, int e){
        int smallest = s;
        while(s <= e){
            if(arr[s] < arr[smallest])
                smallest = s;
            s++;
        }
        return smallest;
    }
    
    static void selectionSort(int[] arr){
        int n = arr.length;
        int i = 0;
        while(i < n-1){
            int smallestIdx = findSmallest(arr, i, n-1);
            swap(arr, i, smallestIdx);
            i++;
        }
    }
    
    //insertion sort - O(N2)
    static void insertIth(int[] arr, int i){
        int key = arr[i];
        int sortedIdx = i-1;
        while(sortedIdx>=0 && key < arr[sortedIdx]){
            arr[sortedIdx+1] = arr[sortedIdx];
            sortedIdx--;
        }
        arr[sortedIdx+1] = key;
    }
    
    static void insertionSort(int[] arr){
        int n = arr.length;
        int i = 1;
        while(i<n){
            insertIth(arr, i);
            i++;
        }
    }
    
    //merge sort - O(NlogN)
    static void merge(int[] arr, int s, int m, int e){
        int[] buffer = new int[e+1];
        int k = s;
        while(k<=e){
            buffer[k] = arr[k];
            k++;
        }
        
        int i = s, j = m+1;
        k = s;
        while(i<=m && j<=e){
            if(buffer[i] <= buffer[j]){
                arr[k++] = buffer[i++];
            }else{
                arr[k++] = buffer[j++];
            }
        }
        while(i<=m){
            arr[k++] = buffer[i++];
        }
        while(j<=e){
            arr[k++] = buffer[j++];
        }
    }
    
    static void mergeSort(int[] arr, int s, int e){
        if(s<e){
            int mid = s + (e-s)/2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid+1, e);
            merge(arr, s, mid, e);
        }
    }
  
  //count sort - O(N)
  // 1 to n or 0 to n && O(N) && O(1) => count sort
  static void countSort(int[] arr){
        int n = arr.length;
        int i = 0;
        while(i<n){
            int currEle = arr[i];
            int correctIdx = currEle-1;
            
            if(i != correctIdx){
                swap(arr, i, correctIdx);
            }else{
                i++;
            }
        }
    }
    
public static void main(String[] args) {
   int[] arr = new int[]{5, 4, 3, 2, 1};
   // selectionSort(arr);
   //bubbleSort(arr);
   //insertionSort(arr);
   //mergeSort(arr, 0, 4);
   //countSort(arr);
	   
   System.out.println(Arrays.toString(arr));
}
}
