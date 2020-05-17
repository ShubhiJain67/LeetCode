class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int num=R*C;
        int [][] ans=new int[num][2];
        int index=0;
        if(r0<R && c0<C)    ans[index++]=new int[]{r0,c0};
        if(r0<R && c0+1<C)  ans[index++]=new int[]{r0,c0+1};
        if(r0+1<R && c0+1<C) ans[index++]=new int[]{r0+1,c0+1};
        if(r0+1<R && c0<C)  ans[index++]=new int[]{r0+1,c0};
        int i=r0+1;
        int j=c0-1;
        int times=1;
        while(index!=num){
            times+=2;
            int count=1;
            for(;count++<=times && index!=num;i--){
                if(isValid(i,j,R,C))   ans[index++]=new int[]{i,j};
            }
            i++;
            j++;
            count=1;
            for(;count++<=times && index!=num;j++){
                if(isValid(i,j,R,C))   ans[index++]=new int[]{i,j};
            }
            i++;
            j--;
            count=1;
            for(;count++<=times && index!=num;i++){
                if(isValid(i,j,R,C))   ans[index++]=new int[]{i,j};
            }
            i--;
            j--;
            count=1;
            for(;count++<=times && index!=num;j--){
                if(isValid(i,j,R,C))    ans[index++]=new int[]{i,j};
            }
            
        }
        return ans;
    }
    public boolean isValid(int i,int j,int R,int C){
        if(i>=0 && j>=0 && i<R && j<C)
            return true;
        return false;
    }
}