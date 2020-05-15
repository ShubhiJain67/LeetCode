class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> an=new ArrayList<>();
        Arrays.sort(candidates);
        if(target==0){
            an.add(new ArrayList<>());
            return an;
        }
        sum(candidates,target,"",0);
        for(List<Integer> l:ans)
            an.add(l);
        return an;
    }
    HashSet<List<Integer>> ans=new HashSet<>();
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
        sum(candidates,target-candidates[index],str+candidates[index]+" ",index+1);
    }
}