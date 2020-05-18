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
//Better complexity
class Solution {
    public int numTilePossibilities(String tiles) {
        return count(tiles);   
    }
    public int count(String tiles){
        int count=0;
        int visited=0;
       for(int i=0;i<tiles.length();i++){
           int mask=(1<<(tiles.charAt(i)-'A'));
           if((visited&mask)==0){
               visited=visited^mask;
               String newTiles=tiles.substring(0,i)+tiles.substring(i+1);
               count+=count(newTiles)+1;
           }
       } 
        return count;
    }
}
