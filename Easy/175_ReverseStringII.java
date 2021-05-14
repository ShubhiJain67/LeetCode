class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int stringLength = s.length();
        boolean reverse = true;
        while(index < stringLength){
            int lastIndex = Math.min(stringLength, index + k);
            if(reverse){
                for(int i = lastIndex - 1; i >= index; i--){
                    sb.append(s.charAt(i));
                }
            }
            else{
                for(int i = index; i < lastIndex; i++){
                    sb.append(s.charAt(i));
                }
            }
            index = lastIndex;
            reverse = !reverse;
        }
        return sb.toString();
    }
}