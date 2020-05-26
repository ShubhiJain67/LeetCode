class Solution {
    public boolean judgeCircle(String moves) {
        int [] ans={0,0};
        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='L'){
                ans[1]-=1;
            }else if(ch=='U'){
                ans[0]-=1;
            }else if(ch=='R'){
                ans[1]+=1;
            }else if(ch=='D'){
                ans[0]+=1;
            }
        }
        return ans[0]==0 && ans[1]==0;
    }
}