class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int ele=nums1[i];
            int next=-1;
            boolean flag=false;
            for(int j=0;j<nums2.length;j++){
                if(!flag){
                    if(nums2[j]==ele){
                        flag=true;
                    }
                }
                else{
                    if(nums2[j]>ele){
                        next=nums2[j];
                        break;
                    }
                }
            }
            ans[i]=next;
        }
        return ans;
    }
}