class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        for(String a:A.split(" ")){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(String b:B.split(" ")){
             map.put(b,map.getOrDefault(b,0)+1);
        }
        for(String a:map.keySet()){
            if(map.get(a)==1)
                list.add(a);
        }
        
        return list.toArray(new String[list.size()]);
    }
}