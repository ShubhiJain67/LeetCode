class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> candidates = new ArrayList(map.keySet());
        Collections.sort(candidates, (w1, w2) -> 
            map.get(w1).equals(map.get(w2)) ?w1.compareTo(w2) : map.get(w2) - map.get(w1));

        return candidates.subList(0, k);
    }
}