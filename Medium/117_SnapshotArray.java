class SnapshotArray {
    int snapCount;
    HashMap<Integer, Integer> array;
    ArrayList<HashMap<Integer, Integer> > snap;
    public SnapshotArray(int length) {
        // System.out.println("Entered Constructor");
        array = new HashMap<>();
        snap=new ArrayList<>();
        snapCount=0;
    }
    
    public void set(int i, int v) {
        // System.out.println("Entered Set");
        array.put(i,v);
        // System.out.println("Have Set "+index+" : "+val);
    }
    
    public int snap() {
        // System.out.println("Entered Snap");
        snap.add(array);
        array=new HashMap<>();
        int i=0;
        for(Integer k:snap.get(snapCount).keySet()){
            array.put(k,snap.get(snapCount).get(k));
        }
        return snapCount++;
    }
    
    public int get(int index, int snap_id) {
        // System.out.println("Entered Get");
        // System.out.println(snapCount);
        // for(int i:snap.get(snap_id))
        //     System.out.print(i+" ");
        HashMap<Integer,Integer> helper=snap.get(snap_id);
        if(helper.containsKey(index)==false)
            return 0;
        return helper.get(index);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */