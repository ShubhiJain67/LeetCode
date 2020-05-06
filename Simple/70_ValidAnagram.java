class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        int alpha[]=new int[26];
        for(int i=0;i<n;i++){
            alpha[s.charAt(i)-'a']++;
            alpha[t.charAt(i)-'a']--;
        }
        for(int num:alpha)
            if(num!=0)
                return false;
        return true;
    }
}