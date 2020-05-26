class Solution {
    public boolean checkIfExist(int[] arr) {
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i:arr){
            if(ar.indexOf((i<<1))!=-1) return true;
            ar.add(i);
        }
        for(int i:arr){
            if(i!=0 && ar.indexOf((i<<1))!=-1) return true;
        }
        return false;
    }
}