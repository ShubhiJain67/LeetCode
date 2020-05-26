class Solution {
    public char findTheDifference(String s, String t) {
        while(t.length()!=1 || s.length()!=0){
            int i=t.indexOf(s.charAt(0));
            if(i==0)
                t=t.substring(1);
            else if(i==(t.length()-1))
                t=t.substring(0,t.length()-1);
            else
                t=t.substring(0,i)+t.substring(i+1);
            s=s.substring(1);
        }
        return t.charAt(0);
    }
}