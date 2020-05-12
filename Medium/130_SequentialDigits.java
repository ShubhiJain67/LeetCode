class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        int ds=getDigit(low);
        int ls=getLast(ds);
        if(low>ls){
            ds++;
            ls=getLast(ds);
        }
        int fs=getFirst(ds);
        int dd=ds;
        int add=0;
        while(dd!=0){
            add=add*10+1;
            dd--;
        }
        while(fs<low)   fs=fs+add;
        while(fs<=high){
            
            while(fs<=ls){
                // System.out.println(fs+" "+high+" "+ls);
                if(fs>high)
                    return ans;
                ans.add(fs);
                fs=fs+add;
            }
            if(fs>high)
                return ans;
            ds++;
            add=add*10+1;
            fs=getFirst(ds);
            ls=getLast(ds);
        }
        
        return ans;
    }
    public int getDigit(int n){
        int ans=0;
        while(n!=0){
            ans++;
            n=n/10;
        }
        return ans;
    }
    
    public int getFirst(int d){
        int dd=1;
        int ans=0;
        while(d!=0){
            ans=ans*10+dd;
            dd++;
            d--;
        }
        return ans;
    }
    
    public int getLast(int d){
        int dd=10-d;
        int ans=0;
        while(d!=0){
            ans=ans*10+dd;
            dd++;
            d--;
        }
        return ans;
    }
}