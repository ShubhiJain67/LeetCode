class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return isBreak(a1, a2) || isBreak(a2, a1);
    }
    
    private boolean isBreak(char[] a1, char[] a2){
        for(int i=0; i<a1.length; i++){
            if(a1[i]<a2[i]){
                return false;
            }
        }
        return true;
    }
}