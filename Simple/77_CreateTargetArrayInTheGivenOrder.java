class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList <Integer> targetList = new ArrayList<Integer>();
        int i=0;
        for (i = 0; i < index.length; i++)
            targetList.add(index[i], nums[i]);
        int []ans=new int[index.length];
        i=0;
        for(Integer n:targetList){
            ans[i++]=n;
        }
        return ans;
    }
}