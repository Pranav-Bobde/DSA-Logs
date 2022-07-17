//Link: https://leetcode.com/problems/find-k-closest-elements/

//Time & Space Complexity: O(NlogN) O(N)

//Using Heap
class Solution {
    class Pair implements Comparator<Pair>{
        int diff;
        int val;
        Pair(){}
        Pair(int d, int v){
            diff = d;
            val = v;
        }
        @Override
        public int compare(Pair p1, Pair p2){
            if(p1.diff > p2.diff || (p1.diff == p2.diff && p1.val > p2.val)){
                return -1;
            }else if(p1.diff < p2.diff || (p1.diff == p2.diff && p1.val < p2.val)){
                return 1;
            }else{
                return 0;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        for(int i : arr){
            int d = Math.abs(i-x);
            pq.add(new Pair(d, i));
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll().val);
        }
        Collections.sort(ans);
        return ans;
    }
}

//Mine
class Solution {
    int bs(int[] arr, int x){
        int n = arr.length;
        int s = 0, e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid] == x){
                return mid;
            }else if(x < arr[mid]){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        if(x > arr[n-1]){
            for(int i=n-1; i>0 && k>0; i--,k--){
                ans.add(arr[i]);
            }
            Collections.sort(ans);
            return ans;
        }
        int idx = bs(arr, x);
        int i=idx, j = idx+1;
        if(i!=0 && Math.abs(arr[i] - x) >= Math.abs(arr[i-1] - x)){
            i = idx-1;
            j=idx;
        }
        if(i!=-1){
            ans.add(arr[i]);
            i--;
            k--;
        }
        while(i>=0 && j<n && k>0){
            if(Math.abs(arr[i] - x) < Math.abs(arr[j] - x)){
                ans.add(arr[i]);
                i--;
                k--;
            }else if(Math.abs(arr[i] - x) > Math.abs(arr[j] - x)){
                ans.add(arr[j]);
                j++;
                k--;
            }else{
                if(arr[i] < arr[j]){
                    ans.add(arr[i]);
                    i--;
                    k--;
                }else{
                    ans.add(arr[j]);
                    j++;
                    k--;
                }
            }
        }
        if(i<0){
            while(j<n && k>0){
                ans.add(arr[j]);
                j++;
                k--;
            }
        }else if(j==n){
            while(i>=0 && k>0){
                ans.add(arr[i]);
                i--;
                k--;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
