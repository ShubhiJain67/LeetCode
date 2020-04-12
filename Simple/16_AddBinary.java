class Solution {
    public String addBinary(String a, String b) {
        int na=0;
        int nb=0;
        int carry=0;
        int sum=0;
        int i=a.length()-1;
        int j=b.length()-1;
        String ans="";
        while(i!=-1 && j!=-1){
            if(a.charAt(i--)=='1') na=1;
            else na=0;
            if(b.charAt(j--)=='1') nb=1;
            else nb=0;
            if(na==1 && nb==1 ){
                sum=carry;
                carry=1;
            }
            else if(na==1 && nb==0){
                if(carry==1){
                    sum=0;
                    carry=1;
                }
                else{
                    sum=1;
                    carry=0;
                }
            }
            else if(nb==1 && na==0){
                if(carry==1){
                    sum=0;
                    carry=1;
                }
                else{
                    sum=1;
                    carry=0;
                }
            }else if(na==0 && nb==0){
                sum=carry;
                carry=0;
            }
            if(sum==0) ans="0"+ans;
            else ans="1"+ans;
        }
        
        
        while(i!=-1){
            if(a.charAt(i--)=='1') na=1;
            else na=0;
            if(na==1 && carry==1){
                sum=0;
                carry=1;
            }
            else if(na==0){
                sum=carry;
                carry=0;
            }
            else{
                sum=na;
                carry=0;
            }
            if(sum==0) ans="0"+ans;
            else ans="1"+ans;
        }
        
        
        while(j!=-1){
            if(b.charAt(j--)=='1') nb=1;
            else nb=0;
            if(nb==1 && carry==1){
                sum=0;
                carry=1;
            }
            else if(nb==0){
                sum=carry;
                carry=0;
            }
            else{
                sum=nb;
                carry=0;
            }
            if(sum==0) ans="0"+ans;
            else ans="1"+ans;
        }
        if(carry==1) ans="1"+ans;
     return ans;   
    }
}
