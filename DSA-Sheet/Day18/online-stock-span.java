//Link: https://leetcode.com/problems/online-stock-span/

//Time & Space: O(N) O(N)

class StockSpanner {
    Stack<Integer> s;
    ArrayList<Integer> al;
    int i = 0;
    public StockSpanner() {
        s = new Stack<>();
        al = new ArrayList<>();
    }
    
    public int next(int price) {
        int ret = -1;
        al.add(price);
        while(!s.isEmpty() && price >= al.get(s.peek())){
            s.pop();
        }
        if(s.isEmpty()){
            ret = ((al.size() -1) + 1);
        }else{
            ret = (al.size() - 1) - s.peek();
        }
        s.push(i++);
        return ret;
    }
}
