class Solution {
    public String multiply(String a, String b) {
        if(a.charAt(0)=='0' || b.charAt(0)=='0') return "0";
        String an="";
        int num1;
        int num2;
        int carry=0;
        int leave=0;
        int [] ans=new int[a.length()+b.length()];
        int aIndex=ans.length-1;
        for(int i=a.length()-1;i>=0;i--){
            num1=a.charAt(i)-'0';
            aIndex=ans.length-1;
            for(int j=b.length()-1;j>=0;j--){
                num2=b.charAt(j)-'0';
                int nn=ans[aIndex-leave]+num1*num2+carry;
                ans[aIndex-leave]=nn%10;
                carry=nn/10;
                System.out.println(aIndex+" "+leave);
                System.out.println(num1+" "+num2+" "+carry+" "+ans[aIndex-leave]);
                aIndex--;
            }
            ans[aIndex-leave]=carry;
            System.out.println(aIndex+" "+leave+" "+ ans[aIndex-leave]);
            carry=0;
            leave++;
        }
        // ans[aIndex]=carry;
        an="";
        for(int i=0;i<ans.length;i++){
            an=an+ans[i];
        }
        char ch=an.charAt(0);
        while(ch=='0'){
            an=an.substring(1);
            ch=an.charAt(0);
        }
        return an;
    }
}