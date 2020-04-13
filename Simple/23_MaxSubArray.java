class Solution {
    public int maxSubArray(int[] nums) {
       return SubArray(nums,0,nums.length-1);
       
    }
    public int SubArray(int [] nums,int i,int j){
        if(j-i==0){
            return nums[j];
        }
            
        int leftsum=SubArray(nums,i,(i+j)/2);
        int rightsum=SubArray(nums,(i+j+2)/2,j);
        int midsum=maxCrossingSum(nums,i,(i+j)/2,j);
        
        if(leftsum>rightsum && leftsum>midsum){
            return leftsum;
        }
        if(rightsum>midsum){
            return rightsum;
        }
        return midsum;
    }
    static int maxCrossingSum(int arr[], int l,int m, int h) 
    { 
        int sum = 0; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = m; i >= l; i--) 
        { 
            sum = sum + arr[i]; 
            if (sum > left_sum) 
            left_sum = sum; 
        } 
        sum = 0; 
        int right_sum = Integer.MIN_VALUE; 
        for (int i = m + 1; i <= h; i++) 
        { 
            sum = sum + arr[i]; 
            if (sum > right_sum) 
            right_sum = sum; 
        } 
        return left_sum + right_sum; 
    } 
  
}