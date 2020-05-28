class Solution {
    public List<Integer> partitionLabels(String S) {
        int alpha[][]=new int[26][2];
         for(int i=0;i<26;i++){
             alpha[i][0]=-1;
             alpha[i][1]=-1;
         }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            int ch=S.charAt(i)-'a';
            if(alpha[ch][0]==-1)
                alpha[ch][0]=i;
            alpha[ch][1]=i; 
        }
        Arrays.sort(alpha,(int[] a,int [] b)->{
            return a[0]-b[0];
        });
        int index=0;
        while(index<26 && alpha[index][0]==-1)
            index++;
        if(index==26)
            return ans;
        int start=alpha[index][0],end=alpha[index][1];
        for(int i=index+1;i<26;i++){
            if(end<alpha[i][0]){
                ans.add(end-start+1);
                start=alpha[i][0];
                end=alpha[i][1];
            }else{
                end=Math.max(end,alpha[i][1]);
            }
        }
        ans.add(end-start+1);
        return ans;
    }
}