class MyHashSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> HashSet;
    public MyHashSet() {
        HashSet=new ArrayList<>();
    }
    
    public void add(int key) {
        if(HashSet.indexOf(key)==-1)
            HashSet.add(key);
    }
    
    public void remove(int key) {
        HashSet.remove(new Integer(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return HashSet.indexOf(key)!=-1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */