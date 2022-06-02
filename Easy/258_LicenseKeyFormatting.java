class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "");
        s = s.toUpperCase();
        int len = s.length() - k;
        StringBuffer str = new StringBuffer(s);
        while(len > 0){
            str.insert(len, '-');
            len = len - k;
        }
        return str.toString();
    }
}