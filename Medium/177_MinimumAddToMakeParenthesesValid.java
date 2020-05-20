class Solution {
    public int minAddToMakeValid(String S) {
        int len=S.length();
        int index=0;
        int count=0;
        for(int i=0;i<len;i++){
            char ch=S.charAt(i);
            if(ch=='(')
                index++;
            else{
                if(index==0)
                    count++;
                else
                    index--;
            }
        }
        return count+index;
    }
}