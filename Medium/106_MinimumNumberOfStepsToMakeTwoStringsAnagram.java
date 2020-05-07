class Solution {
    public int minSteps(String s, String t) {
        int a1[]=new int[26];
        int a2[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            a1[s.charAt(i)-'a']++;
            a2[t.charAt(i)-'a']++;
        }
        int ans=n;
        for(int i=0;i<26;i++){
            // System.out.println(a1[i]+" "+a2[i]+" "+ans);
            if(a1[i]!=0 && a2[i]!=0){
                int sub=a1[i]<a2[i]?a1[i]:a2[i];
                ans=ans-sub;
            }
        }
        return ans;
    }
}