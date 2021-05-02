class Solution {
    public String interpret(String command) {
        String ans = "";
        if(command != null){
            int len = command.length();
            if(len>0){
                for(int i = 0; i < len - 1; i++){
                    char currentChar = command.charAt(i);
                    char nextChar = command.charAt(i + 1);
                    
                    switch(currentChar){
                        case 'G' :
                            ans += 'G';
                            break;
                        case '(' :
                            switch(nextChar){
                                case ')' :
                                    ans += 'o';
                                    i++;
                                    break;
                                default :
                                    ans += "al";
                                    i+=3;
                                    break;
                            }
                            break;
                    }
                }
                char lastChar = command.charAt(len - 1);
                ans += lastChar == 'G' ? 'G' : "";
            }
        }
        return ans;
    }
}