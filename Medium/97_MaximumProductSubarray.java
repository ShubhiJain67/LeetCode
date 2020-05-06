class Solution {
    public int maxProduct(int[] nums) {
	//if only 1 element is present
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int prev=0, next=1;// to store the product of the subarray
        int max=nums[0]; //to store the maximum product recieved ever
        for(int i=0;i<n-1;i++){
		//t store the first element as soon as new initial element of encountered
            prev=nums[i];
			//checking if max is less than tha one encountered
            if(max<prev) max=prev;
            for(int j=i+1;j<n;j++){
			//Stopping the product from becoming 0 for the rest of subarrays
                if(prev==0) prev=1;
				//calculating the new sum
                next=prev*nums[j];
				//checking if max is less than tha one encountered
                if(max<next) max=next;
				//updating the new prev
                prev=next;
                
            }
        }
		//since above loop doesnot cover the last element as an individual subarray. so comapred here
        return max>nums[n-1]?max:nums[n-1];
    }
}