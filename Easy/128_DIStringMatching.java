class Solution {
    public int[] diStringMatch(String S) {
        int len=S.length();
        int ans[]=new int[len+1];
        int num=0;
        int count=0;
        for(int i=0;i<len;i++){
            if(S.charAt(i)=='I')
                ans[i]=num++;
        }
        ans[len]=num++;
        for(int i=len-1;i>=0;i--){
            if(S.charAt(i)=='D')
                ans[i]=num++;
        }
        return ans;
    }
}