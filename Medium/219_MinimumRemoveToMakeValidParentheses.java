class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> leftParenthesis = new Stack<>();
        boolean[] isRemoved = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!leftParenthesis.isEmpty()) {
                    int left = leftParenthesis.pop();
                    isRemoved[left] = false;
                } else {
                    isRemoved[i] = true;
                }
            } else if (c == '(') {
                leftParenthesis.push(i);
                isRemoved[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isRemoved[i]) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}