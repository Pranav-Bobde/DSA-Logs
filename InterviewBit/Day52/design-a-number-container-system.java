//Link: https://leetcode.com/contest/biweekly-contest-83/problems/design-a-number-container-system/

//Time & Space Complexity: O(NLogN) O(N)
//N - No.of ops with distinct no.s

class NumberContainers {
    Map<Integer, Integer> map;
    public NumberContainers() {
        map = new TreeMap<>();
    }
    
    public void change(int index, int number) {
        map.put(index, number);
    }
    
    public int find(int number) {
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()==number)
                return e.getKey();
        }
        return -1;
    }
}
