class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans=new ArrayList<>();
        int num=1;
        for(int x:target){
            while(num<x){
                num++;
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            num++;
        }
        return ans;
    }
}