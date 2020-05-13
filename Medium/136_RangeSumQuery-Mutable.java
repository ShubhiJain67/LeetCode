class NumArray {
    int [] arr;
    int N;
    public NumArray(int[] nums) {
        N=nums.length;
        arr=new int[N];
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=nums[i];
            arr[i]=sum;
        }
    }
    
    public void update(int i, int val) {
        for(int l=i+1;l<N;l++){
            arr[l]=arr[l]-arr[i]+val;
            if(i!=0)
                arr[l]+=arr[i-1];
        }
        arr[i]=val;
        if(i!=0)
                arr[i]+=arr[i-1];
    }
    
    public int sumRange(int i, int j) {
        if(i==0)
            return arr[j];
        return arr[j]-arr[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */