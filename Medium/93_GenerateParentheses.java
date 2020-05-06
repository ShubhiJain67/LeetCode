class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        if(n==0) return ans;
        if(n==1){
            ans.add("()");
            return ans;
        }
        List<String> ret=generateParenthesis(n-1);
        for(String s:ret){
            for(int i=0;i<=s.length()/2;i++){
                String addstr= s.substring(0,i)+"()"+s.substring(i);
                if(ans.indexOf(addstr)==-1)
                    ans.add(addstr);
            }
        }
        return ans;
    }
}