class Solution {
    public int numJewelsInStones(String J, String S) {
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<J.length();i++){
            list.add(J.charAt(i));
        }
        if(list.size()==0 || S.length()==0) return 0;
        int ans=0;
        for(int i=0;i<S.length();i++){
            if(list.indexOf(S.charAt(i))!=-1) ans++;
        }
        return ans;
    }
}