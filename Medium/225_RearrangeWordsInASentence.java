class Solution {
    public String arrangeWords(String text) {
        String[] parts = text.split(" ");
        Arrays.sort(parts, (String s, String t)->{
            return s.length() - t.length(); 
        });
        StringBuilder sb = new StringBuilder("");
        for(String s:parts)
            sb.append(s.toLowerCase() + " ");
        String str = sb.toString();     
        return Character.toUpperCase(str.charAt(0)) + str.substring(1,str.length()-1);
    }
}