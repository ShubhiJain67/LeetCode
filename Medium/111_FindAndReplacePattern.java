class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(String word:words){
            if(isSamePattern(word,pattern))
                ans.add(word);
        }
        return ans;
    }
    public boolean isSamePattern(String word,String pattern){
	//to map the word and the pattern array
         char []ch=new char[26];
        for(int i=0;i<26;i++)
            ch[i]='.';
			//to store the alphabets that have been used before
        int used=0;
        for(int i=0;i<word.length();i++){
            char cw=word.charAt(i);
            char cp=pattern.charAt(i);
			// mask to check the current pattern character is already used or not
            int mask=(1<<(cp-'a'));
            int index=cw-'a';
			//to check if the character is already mapped or not
            if(ch[index]=='.'){  //character is not mapped
				// to chceck is the alphabet is used or not
                if((used&mask)==0){ //alphabet is not used
                    ch[index]=cp;
                    used=used+mask;
                }
                else //alphabet used
                    return false;
            }
            else{  // alphabet already mapped
                if(ch[index]!=cp )
                    return false;
            }
            
        }
        return true;
    }
}
