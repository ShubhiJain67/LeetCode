class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if(len==0)
            return result;
        int pointer1 = 0;
        int pointer2 = len > 1 ? 1 : (len - 1);
        int iter = 1;
        while(pointer1 < pointer2 && pointer2 < len){
            if(nums[pointer1] == nums[pointer2]-iter){
                pointer2++;
                iter++;
            }
            else{
                iter = 1;
                pointer2--;
                result.add(pointer1 == pointer2?Integer.toString(nums[pointer1]):""+nums[pointer1]+"->"+nums[pointer2]);

                pointer1 = pointer2 + 1;
                pointer2 = pointer1 + 1;
            }
        }
        if(pointer2 > 0)
            pointer2--; 
        result.add(pointer1 == pointer2?Integer.toString(nums[pointer1]):""+nums[pointer1]+"->"+nums[pointer2]);
        return result;
    }
}