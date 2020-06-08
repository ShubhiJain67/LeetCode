class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==0 || word.length()==1)
            return true;
        int ch=(int)word.charAt(0);
        if(ch>=65 && ch<=90)
            return AllSame(word.substring(1));
        return AllSame(word);
    }
    private boolean AllSame(String word){
        int ch=(int)word.charAt(0);
        if(ch>=65 && ch<=90){
            for(int i=1;i<word.length();i++){
                ch=(char)word.charAt(i);
                if(ch<65 || ch>90)
                    return false;
                
            }
        }
        else if(ch>=97 && ch<=122){
            for(int i=1;i<word.length();i++){
                ch=(char)word.charAt(i);
                if(ch<97 || ch>122)
                    return false;
                
            }
        }
        return true;
    }
}