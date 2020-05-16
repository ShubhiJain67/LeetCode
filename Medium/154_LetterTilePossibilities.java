class Solution {
    public int numTilePossibilities(String tiles) {
        return helper(tiles,0).size()-1;
    }
    public HashSet<String> helper(String tiles,int index){
        if(index==tiles.length()){
            HashSet<String> ans=new HashSet<>();
            ans.add("");
            return ans;
        }
        HashSet<String> retAns=helper(tiles,index+1);
        HashSet<String> ans=new HashSet<>();
        for(String str:retAns){
            ans.add(str);
            for(int i=0;i<=str.length();i++){
                ans.add(str.substring(0,i)+tiles.charAt(index)+str.substring(i));
            }
        }
        return ans;
    }
}