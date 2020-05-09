class Solution {
    public boolean queryString(String S, int N) {
        for(int i=1;i<=N;i++){
            String str=binary(i);
            if(S.contains(str)==false)
                return false;  
        }
        return true;
    }
    public String binary(int n){
        String ans="";
        while(n!=0){
            ans=n%2+ans;
            n=n/2;
        }
        return ans;
    }
}