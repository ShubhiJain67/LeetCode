class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<Boolean>();
        for(String query:queries){
            ans.add(Match(query,pattern));
        }
        return ans;
    }
    public boolean Match(String str,String pattern){
        while(str.length()!=0 && pattern.length()!=0){
            int ch1=(int)str.charAt(0);
            int ch2=(int)pattern.charAt(0);
            if(ch1>='A' && ch1<='Z' && ch2>='A' && ch2<='Z'){
                if(ch1!=ch2){
                    return false;
                }
                    
                else{
                    str=str.substring(1);
                    pattern=pattern.substring(1);
                }
            }
            else if(ch1>='a' && ch1<='z' && ch2>='a' && ch2<='z'){
                if(ch1!=ch2){
                    str=str.substring(1);
                }
                else{
                    str=str.substring(1);
                    pattern=pattern.substring(1);
                }
            }
            else{
                if(ch1>='A' && ch1<='Z'){ 
                    return false;
                }
                if(ch1>='a' && ch1<='z'){
                    str=str.substring(1);
                }
            }
        }
        while(str.length()!=0){
            if(str.charAt(0)>='A' && str.charAt(0)<='Z') return false;
            str=str.substring(1);
        }
        return pattern.length()==0;
    }
    
}