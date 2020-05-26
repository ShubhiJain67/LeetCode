class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> p:paths){
            map.put(p.get(0),p.get(1));
        }
        for(String key:map.keySet()){
            if(map.containsKey(map.get(key))==false)
                return map.get(key);
        }
        return "";
    }
}