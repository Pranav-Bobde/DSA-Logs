import java.util.*;
public class Main
{
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //selection sort
    public static int findSI(int[] arr, int s, int e){
        int min=s, j=s;
        while(j<=e){
            if(arr[j]<arr[min]){
                min = j;
            }
            j++;
        }
        return min;
    }
    public static void selectSort(int[] arr, int n){
        int i=0;
        while(i<n-1){
            int si = findSI(arr, i, n-1);
            swap(arr, i, si);
            i++;
        }
    }
    
    //bubble sort
    public static void bubble(int[] arr, int n){
        int i=n-1;
        while(i>0){
            if(arr[i]<arr[i-1]){
                swap(arr, i, i-1);
            }
            i--;
        }
    }
    public static void bubbleSort(int[] arr, int n){
        int i=0;
        while(i<n-1){
            bubble(arr, n);
            i++;
        }
    }
    
    //insertion sort
    public static void insert(int[] arr, int i, int n){
        int key = arr[i];
        int j = i-1;
        while(j>=0 && arr[j] > key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1]=key;
    }
    
    public static void insertSort(int[] arr, int n){
        int i = 1;
        while(i<n){
            insert(arr, i, n);
            i++;
        }
    }
    
    //merge sort
    public static void merge(int[] arr, int s, int m, int e){
        int[] temp = new int[e+1];
        int k = s;
        while(k<=e){
            temp[k] = arr[k];
            k++;
        }
        int i = s, j = m+1;
        k = s;
        while(i<=m && j<=e){
            if(temp[i]<=temp[j]){
                arr[k++] = temp[i++];
            }else{
                arr[k++] = temp[j++];
            }
        }
        while(i<=m){
            arr[k++] = temp[i++];
        }
        while(j<=e){
            arr[k++] = temp[j++];
        }
    }
    public static void mergeSort(int[] arr, int s, int e){
        if(s<e){
            int mid = s + (e-s)/2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid+1, e);
            merge(arr, s, mid, e);
        }
    }
    
	public static void main(String[] args) {
	    Random rand = new Random();
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = rand.nextInt(50)+1;
        // selectSort(arr, n);
        // bubbleSort(arr, n);
        // insertSort(arr, n);
        mergeSort(arr, 0, n-1);
		System.out.println(Arrays.toString(arr));
	}
}
