class Solution {
    public int[] decode(int[] encoded, int first) {
        if(encoded != null){
            int encodedLength = encoded.length;
            int ans[] = new int[encodedLength + 1];
            ans[0] = first;
            int i = 1;
            for(int encode : encoded){
                ans[i] = ans[i-1] ^ encode;
                //System.out.println(ans[i - 1] + " ^ " + encode + " = " + ans[i]);
                i++;
            }
            return ans;
        }
        return null;        
    }
}