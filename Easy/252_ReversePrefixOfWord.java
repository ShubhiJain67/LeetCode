class Solution {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        String prefixString = "";
        for(; i < word.length(); i++){
            prefixString = word.charAt(i) + prefixString;
            if(word.charAt(i) == ch){
                break;
            }
        }
        if(i == word.length())
            return word;
        return prefixString + word.substring(i+1);
    }
}