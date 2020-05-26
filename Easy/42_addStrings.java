class Solution {
    public String addStrings(String num1, String num2) {
        String str="";
        int carry=0;
        while(num1.length()!=0 || num2.length()!=0){
            int a=0;
            int b=0;
            if(num1.length()!=0){
                a=num1.charAt(num1.length()-1)-'0';
                num1=num1.substring(0,num1.length()-1);
            }
            if(num2.length()!=0){
                b=num2.charAt(num2.length()-1)-'0';
                num2=num2.substring(0,num2.length()-1);
            }
            int sum=a+b+carry;
            carry=(sum)/10;
            str=(sum%10)+str;
        }
        if(carry!=0){
            str=carry+str;
        }
        return str;
    }
}