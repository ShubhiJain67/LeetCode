class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int num=0,r=0,copy=x;
        while(x!=0){
            r=x%10;
            num=num*10+r;
            x=x/10;
        }
        if(num==copy) return true;
        return false;
    }
}