class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i:nums2)
            list.add(i);
        for(int i:nums1){
            int index=list.indexOf(i);
            if(index!=-1){
                if(ans.indexOf(i)==-1)
                    ans.add(i);
                list.remove(index);
            }
        }
        int [] ansar=new int[ans.size()];
        int index=0;
        for(int i:ans){
            ansar[index++]=i;
        }
        return ansar;
    }
}