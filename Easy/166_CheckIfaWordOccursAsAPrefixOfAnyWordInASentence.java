class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count=0;
        int len=searchWord.length();
        for(String str:sentence.split(" ")){
            if(str.length()>=len){
                int i=0;
                for(;i<len;i++){
                    if(str.charAt(i)!=searchWord.charAt(i))
                        break;
                }
                if(i==len)
                    return count+1;
            }
            count++;
        }
        return -1;
    }
}