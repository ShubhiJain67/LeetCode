class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        ArrayList<String> morse=new ArrayList<>();
        for(String w:words){
            String m=get(w);
            // System.out.println(m);
            if(morse.indexOf(m)==-1)
                morse.add(m);
        }
        return morse.size();
    }
    public String get(String word){
        String morse[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String ans="";
        for(int i=0;i<word.length();i++){
            ans=ans+morse[word.charAt(i)-'a'];
        }
        return ans;
    }
    
}