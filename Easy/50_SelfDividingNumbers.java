class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        for(;left<=right;left++){
            int n=left;
            while(n!=0){
                if(n%10==0 || left%(n%10)!=0) break;
                n=n/10;
            }
            if(n==0) ans.add(left);
        }
        return ans;
    }
}