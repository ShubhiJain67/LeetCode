class Solution {
    public int binaryGap(int N) {
        int count=0;
        int ans=0;
        int prev=-1;
        while(count!=32){
            if((N&(1<<count))!=0){
                if(prev==-1)
                    prev=count;
                else{
                    if(ans<count-prev)
                        ans=count-prev;
                    prev=count;
                }
            }
            count++;
        }
        return ans;
    }
}