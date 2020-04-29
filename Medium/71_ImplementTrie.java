class Trie {

    /** Initialize your data structure here. */
    public class Node{
        int WordEnd;
        Node[]child;
        // String word;    //not required necessarily
        Node(){
            this.child=new Node[27];
            // this.word="";
            this.WordEnd=0;
        }
    }
    
    Node root=null;
    
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            int chIndex=word.charAt(i)-'a';
            
            curr=curr.child[chIndex];
            if(curr==null) return false;
        }
        return curr.WordEnd>=1;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node curr=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            int chIndex=word.charAt(i)-'a';
            curr=curr.child[chIndex];
            if(curr==null){ 
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */