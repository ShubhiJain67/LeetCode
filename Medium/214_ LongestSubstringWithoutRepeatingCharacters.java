class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        int [] dp=new int[len];
        int alpha[]=new int[128];
        Arrays.fill(alpha,-1);
        int end=0;
        int max=0;
        int start=0;
        for(int i=0;i<len;i++){
            int ch=(int)(s.charAt(i));
            end=i;
            if(alpha[ch]!=-1){
                int in=alpha[ch];
                for(int ii=0;ii<128;ii++){
                    if(alpha[ii]<=in) alpha[ii]=-1;
                }
                start=in+1;
            }
            if(max<end-start+1){
                max=end-start+1;
            }
            alpha[ch]=i;
        }
        return max;
    }
}