class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>(); 
        for(Integer key:map.keySet()){
            int val=map.get(key);
            if(list.indexOf(val)==-1){
                list.add(val);
            }else
                return false;
        }
        return true;
    }
}