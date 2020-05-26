class Solution {
    public int[] decompressRLElist(int[] nums) {
        int arrLength=0;
        int l=nums.length;
        for(int i=0;i<l;i=i+2){
            arrLength += nums[i];
        }
        int[] myArr = new int[arrLength];
        int freq =0;
        int val =0;
        int index=0;
        for(int i =0;i<l;i++){
            freq=nums[i++];
            val=nums[i];
            while(freq-->0){
                myArr[index++]=val;
            }
        }
        return myArr;
    }
}