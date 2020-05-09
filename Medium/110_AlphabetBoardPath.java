class Solution {
    public String alphabetBoardPath(String target) {
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0;
        for (char c : target.toCharArray()) {
          int pos = c - 'a';
          int k = pos / 5, l = pos % 5;
          sb.append("U".repeat(Math.max(0, i - k)))
                  .append("R".repeat(Math.max(0, l - j)))
                  .append("L".repeat(Math.max(0, j - l)))
                  .append("D".repeat(Math.max(0, k - i)))
                  .append('!');
          i = k;
          j = l;
        }
        return sb.toString();
    }
}