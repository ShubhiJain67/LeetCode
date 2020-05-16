class Solution {
    String ans="";
    public String getHappyString(int n, int k) {
        num=k;
        GetPerm(n,"",' ');
        return ans;
    }
    int num=0;
    public void GetPerm(int n,String s,char ch){
        if(n==0){
            num--;
            if(num==0){
                ans=s;
            }
            return;
        }
        if(num<0 || n<=0)
            return;
        for(char c='a';c<='c';c++){
            if(c==ch)
                continue;
            GetPerm(n-1,s+c,c);
        }
    }
}