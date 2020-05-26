class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean flag=false;
        if((n&1)!=0){
            flag=true;
        }
        n=n>>>1;
        while(n!=0){
            if((n&1)==0 && flag==false){
                return false;
            }else if((n&1)!=0 && flag==true){
                return false;
            }else{
                n=n>>>1;
                flag=!flag;
            }
        }
        return true;
    }
}