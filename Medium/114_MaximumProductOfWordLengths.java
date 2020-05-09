class Solution {
    public int maxProduct(String[] words) {
        int wlen=words.length;
        int max=0;
        for(int i=0;i<wlen;i++){
            int ilen=words[i].length();
            for(int j=i+1;j<wlen;j++){
                if(HaveNoSame(words[i],words[j])==true){
                    int jlen=words[j].length();
                    int ijlen=ilen*jlen;
                    // System.out.println("entered"+" "+ilen+" "+words[i]+" "+jlen+" "+words[j]+" "+ijlen);
                    if(max<ijlen)
                        max=ijlen;
                }
            }
        }
        return max;
    }
    public boolean HaveNoSame(String a,String b){
        int useda=0;
        int usedb=0;
        int mask=1;
        for(int i=0;i<a.length();i++){
            int ch=a.charAt(i)-'a';
            mask=(1<<ch);
            useda=(useda|mask);
        }
        for(int i=0;i<b.length();i++){
            int ch=b.charAt(i)-'a';
            mask=(1<<ch);
            usedb=(usedb|mask);
            if((useda&usedb)!=0) return false;
        }
        return (useda&usedb)==0;
    }
}