class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length==1) return 1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max=map.get(nums[0]);
        for(int key:map.keySet()){
            int n=map.get(key);
            if(max<n){
                max=n;
            }
        }
        if(max==1) return 1;
        if(max==nums.length) return max;
        ArrayList<Integer> list=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max)
                list.add(key);
        }
        int len=nums.length;
        for(Integer l:list){
            int i=0;
            while(nums[i]!=l)
                i++;
            int j=nums.length-1;
            while(nums[j]!=l)
                j--;
            len=len<(j-i+1)?len:(j-i+1);
            if(len==max)
                return len;
        }
        return len;
    }
}