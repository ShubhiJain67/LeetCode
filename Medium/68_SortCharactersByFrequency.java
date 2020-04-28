class Solution {
    
    class Sort implements Comparator<Map.Entry<Character,Integer>>{
        
        public int compare(Map.Entry<Character,Integer> a, Map.Entry<Character,Integer> b){
                return a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue();
            }
    }
    
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>(new Sort());
        for(int i=0;i<n;i++)
            map.put(str[i],map.getOrDefault(str[i],0)+1);
        
        for(Map.Entry<Character,Integer> m : map.entrySet()){
            heap.offer(m);
        }
    
        StringBuilder ans = new StringBuilder();
        while(heap.size()>0){
            Map.Entry<Character,Integer> m = heap.peek();
            for(int i=0;i<m.getValue();i++)
                ans.append(m.getKey());
            heap.poll();
        }
        ans.reverse();
        return ans.toString();
    }
    
}