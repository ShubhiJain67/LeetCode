class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 < len2 && str2.substring(0, len1).equals(str1)) 
            return gcdOfStrings(str2.substring(len1, len2), str1);
        if(len1 > len2 && str1.substring(0, len2).equals(str2))
            return gcdOfStrings(str1.substring(len2, len1), str2);
        if(str1.equals(str2)) return str1;
        return "";
    }
}