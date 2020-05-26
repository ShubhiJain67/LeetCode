class Solution {
    public int countCharacters(String[] words, String chars) {
        if(chars.length()==0) return 0;
        int givenAlpha[]=new int[26];
        for(int i=0;i<chars.length();i++)
            givenAlpha[chars.charAt(i)-'a']++;
        int sum=0;
        for(String s:words){
            int alpha[]=new int[26];
            int i=0;
            int len=s.length();
            for(;i<len;i++){
                int index=s.charAt(i)-'a';
                if(++alpha[index]>givenAlpha[index])
                    break;
            }
            if(i==len)
                sum+=len;
        }
        return sum;
    }
}