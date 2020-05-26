class Solution {
    
    public int firstUniqChar(String s) {
        ArrayList<Integer> list[]=new ArrayList[26];
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if(list[ch]==null)
                list[ch]=new ArrayList<>();
            list[ch].add(i);
        }
        int min=s.length()+1;
        for(int i=0;i<26;i++){
            if(list[i]!=null && list[i].size()==1 && min>list[i].get(0)){
                min=list[i].get(0);
            }
        }
        return (min==s.length()+1)?-1:min;
    }
}