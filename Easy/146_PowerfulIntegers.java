class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans=new ArrayList<>();
        if(x==1){
            if(y==1){
                if(bound>=2)
                    ans.add(2);
                return ans;
            }
            else
                return Only1(y,bound);
        }
        else if(y==1)
            return Only1(x,bound);
        int num1=1;
        int num2=1;
        while(num1<bound){
            num2=1;
            while(num1+num2<=bound){
                if(ans.indexOf(num1+num2)==-1)
                    ans.add(num1+num2);
                num2=num2*y;
            }
            num1=num1*x;
        }
        // Collections.sort(ans);
       return ans; 
    }
    public List<Integer> Only1(int n,int bound){
        List<Integer> ans=new ArrayList<>();
        int num1=1;
        while(num1+1<=bound){
            if(ans.indexOf(num1+1)==-1)
                ans.add(num1+1);
            num1=num1*n;
        }
        return ans;
    }
}