class Solution {
    public List<String> stringMatching(String[] words) {
        
        if(words==null || words.length==0)
            return new ArrayList<String>();
        
        List<String> ans = new ArrayList<>();
        
        for(String word:words) {
            for(String subword:words) {
                if(!word.equals(subword) && !ans.contains(subword) && word.indexOf(subword) !=-1) {
                   ans.add(subword);
                }
            }
        }
        
        return ans;
    }
}