class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target==0){
            ans.add(new ArrayList<>());
            return ans;
        }
        sum(candidates,target,"",0);
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    public void sum(int[] candidates, int target,String str,int index) {
        if(target==0){
            List<Integer> tans=new ArrayList<>();
           for(String s:str.split(" ")){
               tans.add(Integer.valueOf(s));
           }
            ans.add(tans);
           return;
        }
        if(target<0 || index>=candidates.length)
            return;
        sum(candidates,target,str,index+1);
        sum(candidates,target-candidates[index],str+candidates[index]+" ",index);
    }
}