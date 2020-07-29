class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        int count=0;
        for(int k:map.keySet())
            count+=get(map.get(k));
        return count;
    }
    private int get(int n){
        int ans=0;
        while(n!=1){
            ans+=(n-1);
            n--;
        }
        return ans;
    }
}