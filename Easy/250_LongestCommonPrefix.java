class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String str=strs[0];
       for(int i=1;i<strs.length;i++){
           str=Common(str,strs[i]);
           // System.out.println(i+" "+str);
       }
        return str;
    }
    public String Common(String a,String b){
        int i=0,j=0;
        String ans="";
        while(i!=a.length() && j!=b.length()){
            if(a.charAt(i)==b.charAt(j)){
                ans+=a.charAt(i);
                // System.out.println(num+" "+ans);
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}