//Link: https://leetcode.com/problems/lru-cache/

//Time & Space: O(N) O(C); C-> Cache Capacity, N-> Number of Operations

class LRUCache {
    class Node{
        int key, val;
        Node next, prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    int cap;
    HashMap<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void delete(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void insert(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            delete(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        if(map.size()>cap){
            Node toDel = head.next;
            delete(toDel);
            map.remove(toDel.key);
        }
    }
}
