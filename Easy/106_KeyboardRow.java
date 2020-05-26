class Solution {
    public String[] findWords(String[] words) {
        int []alpha={2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        ArrayList<String> ans=new ArrayList<>();
        for(String w:words){
            int i=0;
            int num=0;
            for(;i<w.length();i++){
                char ch=w.charAt(i);
                if(ch>='a' && ch<='z'){
                    int c=alpha[ch-'a'];
                    if(num==0)
                        num=c;
                    else if(c!=num)
                        break;
                }
                else{
                    int c=alpha[ch-'A'];
                    if(num==0)
                        num=c;
                    else if(c!=num)
                        break;
                }
            }
            if(i==w.length())
                ans.add(w);            
        }
        return ans.toArray(new String[0]);
    }
}