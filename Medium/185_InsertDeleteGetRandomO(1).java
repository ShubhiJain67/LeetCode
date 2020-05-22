class RandomizedSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> list;
    int size;
    public RandomizedSet() {
        this.list=new ArrayList<>();
        this.size=0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(this.list.indexOf(val)==-1){
            this.list.add(val);
            this.size++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(this.list.indexOf(val)==-1)
            return false;
        this.list.remove(new Integer(val));
        this.size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(this.size==0)
            return -1;
        return this.list.get((int)Math.floor(Math.random()*this.size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */