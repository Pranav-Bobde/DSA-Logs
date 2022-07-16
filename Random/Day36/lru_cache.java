//https://leetcode.com/problems/lru-cache/

//Time & Space Complexity: O(1) O(N) N-> cache capacity

class LRUCache {
    class Node{
        int key, val;
        Node prev, next;
        Node(int k, int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
    
    int cap;
    Node left, right;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    void insert(Node node){
        Node nxt = right;
        Node prev = right.prev;
        prev.next = nxt.prev = node;
        node.prev = prev;
        node.next = nxt;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node toAdd = new Node(key, value);
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            map.remove(key);
        }
        insert(toAdd);
        map.put(key, toAdd);
        if(map.size() > cap){
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
