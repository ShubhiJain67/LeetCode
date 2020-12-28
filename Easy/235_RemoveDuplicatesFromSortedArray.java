class RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
        int nums[]= {0,0,0,0,1,1,2,2,5,5,6,7,8,8,8,8};
        int len=arr.length;
        int finLen = removeDuplicates(nums,len);
        print(nums,finLen);
    }
    public static int removeDuplicates(int[] nums,int len) {
        if(len==0 || len==1){
            return len;
        }
        int prevpointer = 0;
        for(int curr = 1; curr < len; curr++){
            while(curr < len && nums[curr] == nums[prevpointer]){
                curr++;
            }
            if(curr<len){
                nums[++prevpointer]=nums[curr];
            }
        }
        return prevpointer+1;
    }
    public static void print(int [] nums,int len){
        for (int i = 0; i<len;i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}