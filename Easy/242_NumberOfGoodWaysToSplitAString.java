class Solution {
    public int numSplits(String s) {
        int count = 0;
        if(s != null && s.length() > 0){
            int stringLength = s.length();
            int frequency[] = new int[26];
            int rightMask = 0, index = 0;
            for(int i = 0; i < stringLength; i++){
                //fetching bit index of the current character
                index = s.charAt(i)-'a';
                //updating frequency count
                frequency[index]++;
                //building right mask
                rightMask =(rightMask | (1 << index));
                //System.out.println(rightMask);
            }
            int leftMask = 0;
            for(int i = 0; i < stringLength - 1; i++){
                //fetching bit index of the current character
                index = s.charAt(i)-'a';
                //building left mask
                leftMask =(leftMask | (1 << index));
                //updating frequency count
                frequency[index]--;
                //updating right mask
                if(frequency[index] == 0){
                    rightMask =(rightMask & (~(1 << index))); 
                }
                if(countSetBits(leftMask) == countSetBits(rightMask)){
                    count++;
                }
            }
        }
        return count;
    }
    private int countSetBits(int mask){
        int count = 0;
        while(mask != 0){
            count++;
            mask = mask & (mask -1);
        }
        return count;
    }
}