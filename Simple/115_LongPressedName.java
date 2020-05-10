class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;int j=0;
        int nlen=name.length();
        int tlen=typed.length();
        while(i<nlen && j<tlen){
            char nc=name.charAt(i++);
            char tc=typed.charAt(j++);
            if(nc!=tc) return false;
            int count1=1;
            while(i<nlen && name.charAt(i)==nc){
                count1++;
                i++;
            }
            int count2=1;
            while(j<tlen && typed.charAt(j)==tc){
                count2++;
                j++;
            }
            if(count1>count2) return false;
        }
        return i==nlen && j==tlen; 
    }
}