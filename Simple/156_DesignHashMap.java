class MyHashMap {

    /** Initialize your data structure here. */
    int [] HashMap;
    public MyHashMap() {
        HashMap=new int [1000000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        HashMap[key]=value+1;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return HashMap[key]-1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        HashMap[key]=0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */