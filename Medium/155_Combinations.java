class Solution {
    public List<List<Integer>> combine(int n, int k) {
        help(n,k,0,"");
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    public void help(int n,int k,int curr,String str){
        // System.out.println("Call For : "+k+" : "+curr);
        if(k==0){
            List<Integer> a=new ArrayList<>();
            for(String s:str.split(" ")){
                a.add(Integer.valueOf(s));
            }
            ans.add(a);
            return;
        }
        for(int i=curr+1;i<=n;i++){
            if(n-i+1>=k)
                help(n,k-1,i,str+i+" ");
        }
    }
}