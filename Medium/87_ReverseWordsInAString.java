class Solution {
    public String reverseWords(String s) {
        String ans="";
        for(String str:s.split(" ")){
            if(str.length()!=0){
                ans=str+" "+ans;
            }            
        }
        ans=ans.trim();
        return ans;
    }
}