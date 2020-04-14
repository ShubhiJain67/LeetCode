class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        
        shifts[shifts.length-1]=shifts[shifts.length-1]%52;
        
        for(int i=shifts.length-2;i>=0;i--)
            shifts[i]=(shifts[i]+shifts[i+1])%52;
        
        for(int i=0;i<shifts.length;i++){
            shifts[i]+=((int)S.charAt(i));
            while(shifts[i]>122)
                shifts[i]=shifts[i]-26;
        }
        
        String str="";
        for(int i=0;i<shifts.length;i++)
            str=str+(char)shifts[i];
        return str;
    }
}