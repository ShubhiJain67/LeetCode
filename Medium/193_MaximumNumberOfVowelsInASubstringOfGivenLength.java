class Solution {
    public int maxVowels(String s, int k) {
        int len=s.length();
        int [] count=new int[len-k+1];
        int prev=is(s.charAt(0));
        if(len<=k){
            int ans=0;
            for(int i=0;i<len;i++){
                ans+=is(s.charAt(i));
            }
            return ans;
        }
        for(int i=0;i<k;i++)
            count[0]+=is(s.charAt(i));
        int max=count[0];
        for(int i=1;i<=len-k;i++){
            count[i]=count[i-1]-prev+is(s.charAt(i+k-1));
            prev=is(s.charAt(i));
            if(count[i]>max)
                max=count[i];
            if(max==k)
                return k;
        }
        // for(int c:count)
        //     System.out.print(c+" ");
        return max;
    }
    public int is(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return 1;
        return 0;
    }
}