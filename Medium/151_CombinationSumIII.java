class Solution {
    public List<List<Integer>> combinationSum3(int count, int target) {
        int candidates[]={1,2,3,4,5,6,7,8,9};
        if(target==0)
            return new ArrayList<>();
        if(count==1){
            List<Integer> a=new ArrayList<>();
            a.add(target);
            ans.add(a);
            return ans;
        }
        sum(candidates,target,"",0,count);
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    public void sum(int[] candidates, int target,String str,int index,int count) {
        if(target==0 && count==0){
            List<Integer> tans=new ArrayList<>();
           for(String s:str.split(" ")){
               tans.add(Integer.valueOf(s));
           }
            ans.add(tans);
           return;
        }
        if(target<0 || index>=candidates.length || count==0)
            return;
        sum(candidates,target,str,index+1,count);
        sum(candidates,target-candidates[index],str+candidates[index]+" ",index+1,count-1);
    }
}