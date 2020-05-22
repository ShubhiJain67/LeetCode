class Solution {
    public int maxPower(String s) {
        int i=0,len=s.length(),max=1;
        while(i<len){
            int count=0;
            char ch=s.charAt(i);
            while(i<len && ch==s.charAt(i)){
                i++;
                count++;
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }
}