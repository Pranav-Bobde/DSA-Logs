//Link: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion

//Time & Space: O(N) O(N)

public class Main {

    public static int solution(int[] arr) {
        int n = arr.length;
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        int c0 = 0, c1 = 0, c2 = 0;
        String key = (c1-c0) + "," + (c2-c1);
        map.put(key, -1);
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                c0++;
            }else if(arr[i]==1){
                c1++;
            }else{
                c2++;
            }
            key = (c1-c0)+","+(c2-c1);
            if(map.containsKey(key)){
                max = Math.max(i - map.get(key), max);
            }else{
                map.put(key, i);
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
