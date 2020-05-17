class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int sum=GetSum(weights);
        int max=GetMax(weights);
        if(D==1) return sum;
        int avrg=(int)(Math.ceil((sum)/D));
        avrg=avrg>max?avrg:max;
        for(int w=avrg;w<=sum;w++){
            int s=0;
            int i=0;
            int d=0;
            while(i<weights.length){
                while(i<weights.length && s+weights[i]<=w)
                    s+=weights[i++];
                d++;
                s=0;
            }
            if(d<=D)
                return w;
        }
        return sum; 
    }
    public int GetSum(int [] weights){
        int sum=0;
        for(int w:weights)
            sum+=w;
        return sum;
    }
    public int GetMax(int [] weights){
        int max=0;
        for(int w:weights)
            if(max<w)
                max=w;
        return max;
    }
}