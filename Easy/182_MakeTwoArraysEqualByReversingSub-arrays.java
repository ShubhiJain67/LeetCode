class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        ArrayList<Integer> t=new ArrayList<>();
        for(int i:arr)
            t.add(i);
        for(int i:target){
            int index=t.indexOf(i);
            if(index==-1)
                return false;
            t.remove(index);
        }
        return true;
    }
}