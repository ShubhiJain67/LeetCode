class WordDictionary {

    /** Initialize your data structure here. */
    public class Node{
        int WordEnd;
        Node[]child;
        // String word;    //not required necessarily
        Node(){
            this.child=new Node[26];
            // this.word="";
            this.WordEnd=0;
        }
    }
    
    Node root=null;
    
    public WordDictionary() {
        root=new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            int chIndex=word.charAt(i)-'a';
            if(curr.child[chIndex]==null)
                curr.child[chIndex]=new Node();
            
            curr=curr.child[chIndex];
        }
        curr.WordEnd++;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search_(root,word);
    }
    public boolean search_(Node curr,String word) {
        if(curr==null) return false;
        
        if(word.length()==0) return curr.WordEnd>0;
        
        boolean res=false;
        if(word.charAt(0)=='.'){
            for(int j=0;j<26;j++){
                if(curr.child[j]!=null)
                    res=res|| search_(curr.child[j],word.substring(1));
            }
        }
        else{
            int id=word.charAt(0)-'a';
            if(curr.child[id]!=null)
            res=res|| search_(curr.child[id],word.substring(1));
        }
        return res;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */