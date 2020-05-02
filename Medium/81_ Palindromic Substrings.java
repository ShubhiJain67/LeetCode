class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isPalindrome(s.substring(i,j))==true)
                    count++;
            }
        }
        return count;
    }
    public boolean isPalindrome(String str){
        if(str.length()==1) return true;
        int l=0;
        int h=str.length()-1;
        while(l<=h){
            if(str.charAt(l++)!=str.charAt(h--)){
                return false;
            }
        }
        return true;
    }
}