class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        int mask=1;
        while(n-->0){
            int index=ans.size()-1;
            while(index>=0){
                ans.add(ans.get(index--)+mask);
            }
            mask=mask<<1;
        }
        return ans;
    }
}