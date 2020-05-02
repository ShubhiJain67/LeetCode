class Solution {
    public boolean buddyStrings(String A, String B) {
        int i=0;
        int j=A.length()-1;
        if(j!=B.length()-1 || j==0 || j==-1) return false;
        while( i<=j && A.charAt(i)==B.charAt(i)){
            i++;
        }
        if(i>j){
            int ch[]=new int[26];
            for(int l=0;l<=j;l++){
                ch[A.charAt(l)-'a']++;
                if(ch[A.charAt(l)-'a']>1) return true;
            }
            return false;
        }
        while(A.charAt(j)==B.charAt(j)){
            j--;
        }
        if(A.charAt(i)==B.charAt(j) && A.charAt(j)==B.charAt(i)){         
            A=A.substring(i+1,j);
            B=B.substring(i+1,j);
        }
        return A.compareTo(B)==0;
    }
}