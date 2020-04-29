class Solution {
    public class Node{
        int WordEnd;
        Node[]child;
        String word;    
        Node(){
            this.child=new Node[26];
            this.word="";
            this.WordEnd=0;
        }
    }
    Node root=null;
    
    public void insert(String word){
        Node node=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            int chInd=word.charAt(i)-'a';
            if(node.child[chInd]==null)
                node.child[chInd]=new Node();
            
            node=node.child[chInd];
        }
        node.WordEnd++;
        node.word=word;
    }
    List<String> ans=new ArrayList<>();
    
    int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public void DFS(int i, int j,Node node,char [][] board){
        if(node.WordEnd>0){
            ans.add(node.word);
            node.WordEnd=0;
        }
        char ch=board[i][j];
        board[i][j]='$';
        for(int d=0;d<4;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]!='$' && node.child[board[r][c]-'a']!=null){
                System.out.println("In : "+board[r][c]);
                DFS(r,c,node.child[board[r][c]-'a'],board);
            }
        }
        board[i][j]=ch;
        
    }
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length==0 || board[0].length==0 || words.length==0)
            return new ArrayList<String>();
        
        root=new Node();
        for(String word:words){
            insert(word);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int chInt=board[i][j]-'a';
                if(root.child[chInt]!=null){
                    System.out.println(board[i][j]);
                    DFS(i,j,root.child[chInt],board);
                }
            }
        }
        return ans;
    }
}