//https://practice.geeksforgeeks.org/problems/factorial5739/1

//Time & Space Complexity: O(N) O(N)

class Solution{
    static long fac(int n, HashMap<Integer, Long> map){
        if(map.containsKey(n)) return map.get(n);
        if(n<=1) return 1;
        long temp = n * fac(n-1, map);
        map.put(n, temp);
        return temp;
    }
    static long factorial(int N){
        return fac(N, new HashMap<Integer, Long>());
    }
}
