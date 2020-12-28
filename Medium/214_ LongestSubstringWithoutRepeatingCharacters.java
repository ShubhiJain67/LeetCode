class Solution {
    public int lengthOfLongestSubstring(String s){
        return Approach_2(s);
    }
    // TC : O(n^3) SC : O(1)
    public int Approach_1(String s){
        int len = s.length(),maxLen=0;
        if( len == 0 || len == 1){
            return len;
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(unique(s,i,j)){
                    if(maxLen<j-i){
                        maxLen=j-i;
                    }
                }
            }
        }
        return maxLen;
    }
    public boolean unique(String s,int start,int end){
        int lastFound[]=new int[128];
        for(int i=0;i<128;i++){
            lastFound[i]=-1;
        }
        while(start<end){
            char ch = s.charAt(start);
            int ch_ascii = (int)ch;
            if( lastFound[ch_ascii]!=-1 ){
                return false;
            }
            lastFound[ch_ascii]=start;
            start++;
        }
        return true;
    }

    // TC : O(n) SC : O(1)
    public int Approach_2(String s){
        int len = s.length();
        if( len == 0 || len == 1){
            return len;
        }
        int lastFound[]=new int[128];
        for(int i=0;i<128;i++){
            lastFound[i]=-1;
        }
        
        int start = 0, curr = 0, maxLen = 0;
        
        while( curr<len ){
            if( maxLen < curr-start )
                maxLen=curr-start;
            char ch = s.charAt(curr);
            int ch_ascii = (int)ch;
            if( lastFound[ch_ascii]>=start )
                start=lastFound[ch_ascii]+1;
            lastFound[ch_ascii] = curr;
            curr++;
        }
        if( maxLen < curr-start )
            maxLen=curr-start;
        return maxLen;
    }
}