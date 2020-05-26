class Solution {
    public int numSpecialEquivGroups(String[] A) {
        int len=A.length;
        int ans=len;
        boolean visited[]=new boolean[len];
        for(int i=0;i<len;i++){
            if(visited[i]==false){
                for(int j=i+1;j<len;j++){
                    if(visited[j]==false){
                        if(Similar(A[i],A[j])==true){
                            ans--;
                            visited[j]=true;
                            visited[i]=true;
                            
                        }
                    }
                }
            }
        }
        return ans;
    }
    public boolean Similar(String a,String b){
        if(a.length()!=b.length()) return false;
        int len=a.length();
        int [] acountEven=new int[26];
        int [] acountOdd=new int[26];
        int [] bcountOdd=new int[26];
        int [] bcountEven=new int[26];
        for(int i=0;i<len;i++){
            if(i%2==0){
                acountEven[a.charAt(i)-'a']++;
                bcountEven[b.charAt(i)-'a']++;
            }else{
                acountOdd[a.charAt(i)-'a']++;
                bcountOdd[b.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if(acountEven[i]!=bcountEven[i] || acountOdd[i]!=bcountOdd[i])
                return false;
        }
        return true;
    }
}