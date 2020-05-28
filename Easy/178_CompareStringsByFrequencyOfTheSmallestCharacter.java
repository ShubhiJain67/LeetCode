class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int q[]=new int[queries.length];
        int ans[]=new int[queries.length];
        int w[]=new int[words.length];
        
        for(int i=0;i<queries.length;i++){
            q[i]=get(queries[i]);
        }
        for(int i=0;i<words.length;i++){
            w[i]=get(words[i]);
        }
        
        for(int i=0;i<queries.length;i++){
            int count=0;
            for(int ww:w){
                if(ww>q[i])
                    count++;
            }
            ans[i]=count;
        }
        return ans;        
    }
    private int get(String word){
        char alpha='z';
        int count=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            // System.out.println(alpha+" "+ch);
            if(alpha>ch){
                alpha=ch;
                count=1;
            }else if(alpha==ch)
                count++;
        }
        return count;
    }
}