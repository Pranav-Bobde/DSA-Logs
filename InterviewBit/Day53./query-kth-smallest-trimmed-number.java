//Link: https://leetcode.com/contest/weekly-contest-302/problems/query-kth-smallest-trimmed-number/

//Time & Space Complexity: O() O()

class Node {
    String n;
    int idx;
    Node(String s, int i){
        n = s;
        idx = i;
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String str = nums[i];
            int l = str.length();
            for(int j=0; j<str.length(); j++){
                map.putIfAbsent(l, new ArrayList<>());
                map.get(l--).add(new Node(swtr.substring(j), i));
            }
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] arr : queries){
            int small = arr[0];
            int rem = arr[1];
            List<Node> list = map.get(rem);
            Collections.sort(list, (p1, p2) -> {
                if(p1.n.equals(p2.n)){
                    return p1.idx - p2.idx;
                }
                return p1.n.compareTo(p2.n);
            });
            ans[idx++] = list.get(small-1).idx;
        }
        return ans;
    }
}
