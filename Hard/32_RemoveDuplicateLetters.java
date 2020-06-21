class Solution{
    public String removeDuplicateLetters(String sr) {
        boolean visited[]=new boolean[26];
        int stack[]=new int[26];
        int count[]=new int[26];
        int len=sr.length(),top=-1;
        for(int i=0;i<len;i++)
            count[sr.charAt(i)-'a']++;
        for(int i=0;i<len;i++){
            int ch=(int)sr.charAt(i);
            count[ch-'a']--;
            if(visited[ch-97])  continue;
            while(top!=-1 && ch<stack[top] && count[stack[top]-97]!=0)
                visited[stack[top--]-97]=false;
            
            stack[++top]=ch;
            visited[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder("");
        while(top!=-1)
            sb.append((char)stack[top--]);
        return sb.reverse().toString();
    }
}