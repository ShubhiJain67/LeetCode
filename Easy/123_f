class Solution {
    public List commonChars(String[] A) {
        int[] charArray=new int[26];
        int[] countArray=new int[26];
        for(int i=0;i<A[0].length();i++){
             char c=A[0].charAt(i);
             countArray[c-'a']++;
        }
        for(int k=1;k<A.length;k++){
            String s=A[k];
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(countArray[c-'a']>=1){
                    charArray[c-'a']++;
                }
            }
            for(int i=0;i<26;i++){
                countArray[i]=Math.min(charArray[i],countArray[i]);
                charArray[i]=0;
            }
        }
        List<String> res=new ArrayList<>();
        for(int i=0;i<26;i++){
             if(countArray[i]>0){
                 int j=countArray[i];             
                 while(j>0){
                     res.add(String.valueOf( (char) (97+i) ));
                     j--;
                 }
             }     
        }
        return res;
    }
}