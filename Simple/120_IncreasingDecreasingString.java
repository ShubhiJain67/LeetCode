class Solution {
    public String sortString(String s) {
        int [] alphabet=new int[26];
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-'a']++;
        }
        String str="";
        int i=0;
        while(i<s.length()){
            for(int j=0;j<26;j++){
                if(alphabet[j]!=0){
                    str=str+(char)(j+'a');
                    i++;
                    alphabet[j]--;
                }
            }
            for(int j=25;j>=0;j--){
                if(alphabet[j]!=0){
                    str=str+(char)(j+'a');
                    i++;
                    alphabet[j]--;
                }
            }
        }
        return str;
    }
}