class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m=magazine.length();
        int n=ransomNote.length();
        if(n==0) return true;
        if(n>m || m==0) return false;
        ArrayList<Character> alpha=new ArrayList<>();
        for(int i=0;i<m;i++){
            alpha.add(magazine.charAt(i));
        }
        int i=0;
        while(alpha.size()!=0 && i!=n){
            char ch=ransomNote.charAt(i);
            if(alpha.contains(ch)){
                i++;
                alpha.remove(new Character(ch));
            }else{
                return false;
            }
        }
        return i==n;
    }
}