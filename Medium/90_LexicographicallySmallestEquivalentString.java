class lexicographically{
    public static void main(String[] args) {
        String a="leetcode";
        String b="programs";
        String S="sourcecode";
        char parent[]=new char[26];
        for(int i=0;i<26;i++){
            parent[i]=(char)('a'+i);
        }
        for(int i=0;i<a.length();i++){
            char ca=a.charAt(i);
            char cb=b.charAt(i);
            char pca=findParent(parent,ca);
            char pcb=findParent(parent,cb);
            parent[ca-'a']=pca<pcb?pca:pcb;
            parent[cb-'a']=parent[ca-'a'];
        }
        String ans="";
        for(int i=0;i<a.length();i++){
            ans=ans+findParent(parent, S.charAt(i));
        }
        System.out.println(ans);

    }
    public static char findParent(char [] parent,char ch){
        char child=ch;
        char par=parent[ch-'a'];
        while(child!=par){
            child=par;
            par=parent[child-'a'];
        }
        return child;
    }
}