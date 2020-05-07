class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer> helper[]=new ArrayList[groupSizes.length+1];
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            if(helper[groupSizes[i]]==null)
                helper[groupSizes[i]]=new ArrayList<>();
            helper[groupSizes[i]].add(i);
        }
        for(int i=0;i<helper.length;i++){
            if(helper[i]!=null){
                int len=i;
                List<Integer> h=new ArrayList<>();
                for(int num:helper[i]){
                    h.add(num);
                    len--;
                    if(len==0){
                        len=i;
                        ans.add(h);
                        h=new ArrayList<>();
                    }
                }
            }          
        }
        return ans;
    }
}