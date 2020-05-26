class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean c[]=new boolean[26];
        for(char ch:letters)
            c[ch-'a']=true;
        int index=(target-'a'+1)%26;
        while(index!=(target-'a')){
            if(c[index]==true)
                return (char)(index+'a');
            index=(index+1)%26;
        }
        return ' ';
    }
}