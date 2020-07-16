class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int ans=0;
        for(int i:nums){
            int len=1;
            set.remove(i);
            int nextEle=i+1;
            int prevEle=i-1;
            while(set.contains(nextEle)){
                len++;
                set.remove(nextEle);
                nextEle++;
            }
            while(set.contains(prevEle)){
                len++;
                set.remove(prevEle);
                prevEle--;
            }
            if(ans<len)
                ans=len;
        }
        return ans;
    }
}