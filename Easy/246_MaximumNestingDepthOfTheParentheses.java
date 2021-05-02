class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0, stackLen = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(' :
                    maxDepth = maxDepth > ++stackLen ? maxDepth : stackLen;
                    break;
                case ')' :
                    stackLen--;    
                    break;
            }
        }
        return maxDepth;
    }
}