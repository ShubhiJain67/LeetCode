class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n=A.length;
        if(n<3)
            return 0;
        int count[]=new int[n-1],ans=0;
        count[0]=1;
        for(int i=1;i<n-1;i++)
            count[i]=(A[i+1]-A[i]==A[i]-A[i-1])?count[i-1]+1:1;
        int pointer=1;
        while(pointer<n-2){
            if(count[pointer-1]<count[pointer] && count[pointer]>count[pointer+1])
                ans+=((count[pointer]-1)*count[pointer])/2;
            pointer++;
        }
        ans+=((count[pointer]-1)*count[pointer])/2;
        return ans;
    }
}