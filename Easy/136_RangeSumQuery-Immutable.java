class NumArray {
    
    int [] arr;
    public NumArray(int[] nums) {
        int len=nums.length;
        arr=new int[len];
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            arr[i]=sum;
        }
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
 * int param_1 = obj.sumRange(i,j);
 */