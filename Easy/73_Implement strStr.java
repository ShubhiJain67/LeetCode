class Solution {
    public int strStr(String haystack, String needle) {
        int hlen=haystack.length();
        int nlen=needle.length();
        if(nlen==0) return 0;
        if(hlen==0 || hlen<nlen) return -1;
        if(hlen==nlen && haystack.charAt(0)!=needle.charAt(0)) return -1;
        char c=needle.charAt(0);
        for(int j=0;j<hlen;j++){
            if((hlen-j)<nlen) return -1;
            if(c==haystack.charAt(j)){
                int ret=find(needle,haystack,j,0,hlen,nlen);
                if(ret!=-1) return ret;
            }
        }
        return -1;
    }
    public int find(String needle,String haystack,int hi,int ni,int hlen,int nlen){
        if(ni==nlen) return hi-ni;
        if(hi==hlen) return -1;
        if(needle.charAt(ni)==haystack.charAt(hi))
            return find(needle,haystack,hi+1,ni+1,hlen,nlen);
        return -1;
    }
    
}