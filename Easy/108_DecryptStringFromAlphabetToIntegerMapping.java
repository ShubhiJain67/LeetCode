class Solution {
    public String freqAlphabets(String s) {
        int len=s.length();
        String str="";
        int i=0;
        while(i<len){
            int num1=s.charAt(i)-'0';
            if((num1==1 || num1==2 ) && i+2<len && s.charAt(i+2)=='#'){
                num1=num1*10+(s.charAt(i+1)-'0');
                i=i+3;
            }else
                i++;
            str=str+(char)('a'+num1-1);
            // System.out.println(str);
        }
        return str;
    }
}