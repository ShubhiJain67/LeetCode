class Solution {
    public String toGoatLatin(String S) {
        String ans="";
        String []str=S.split(" ");
        int i=1;
        int len=str.length;
        for(String s:str){
            char ch=s.charAt(0);
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u' && ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U'){
                s=s.substring(1)+ch;
            }
            s=s+"ma";
            int ii=i;
            while(ii-->0)
                s=s+"a";
            ans=ans+s;
            if(i!=len)
                ans=ans+" ";
            i++;            
        }
        return ans;
    }
}