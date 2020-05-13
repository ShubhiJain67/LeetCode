class Solution {
    public String removeKdigits(String num, int k) {
        while(k-->0){
            num=remove(num);
            num=removeLeadingZeros(num);
            if(num.length()==0)
                return "0";
            
        }
        if(num.length()==0)
            return "0";
        return num;
    }
    public String remove(String str){
        int len=str.length();
        if(len<=1) return "";
        int i=0;
        int j=1;
        while(j!=str.length() && str.charAt(i)<=str.charAt(j)){
            i++;
            j++;
        }
        return str.substring(0,i)+str.substring(j);
    }
    public String removeLeadingZeros(String num){
        int i=0;
        while(i!=num.length() && num.charAt(i)=='0')
            i++;
        return num.substring(i);
    }
}