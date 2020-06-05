class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums,0,nums.length-1);
        return nums;
    }
    private void MergeSort(int [] nums,int i,int j){
        if(i==j)
            return;
        int mid=(i+j)/2;
        MergeSort(nums,i, mid);
        MergeSort(nums,mid+1,j);
        Merge(nums,i,mid,mid+1,j);
    }
    private void Merge(int [] nums,int i1,int j1,int i2,int j2){
        int arr1[]=new int[j1-i1+1];
        int arr2[]=new int[j2-i2+1];
        int i=0;
        for(int a=i1;a<=j1;a++){
            arr1[i++]=nums[a];
        }
        i=0;
        for(int a=i2;a<=j2;a++){
            arr2[i++]=nums[a];
        }
        int a=0,b=0,h=i1;
        while(a<arr1.length && b<arr2.length){
            if(arr1[a]<arr2[b]){
                nums[h++]=arr1[a++];
            }
            else{
                nums[h++]=arr2[b++];
            }
        }
        while(a<arr1.length)
            nums[h++]=arr1[a++];
        while(b<arr2.length)
            nums[h++]=arr2[b++];
    }
}