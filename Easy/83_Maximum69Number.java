class Solution {
    public int maximum69Number (int num) {
        int ans=0;
        boolean flag=false;
        //----Reversing the number----
		int n=num;
        num=0;
        while(n!=0){
            num=num*10+n%10;
            n=n/10;
        }
		//----replacing the first the 6 encountered as 9 and storing the number in reverse order----
        while(num!=0){
            int r=num%10;
            if(flag==false && r==6){
                ans=ans*10+9;
                flag=true;
            }else{
                ans=ans*10+r;
            }
            num=num/10;
        }
        return ans;
    }
}