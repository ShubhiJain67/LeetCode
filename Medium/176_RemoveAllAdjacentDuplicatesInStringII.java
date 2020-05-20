class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st= new Stack<Character>();
        int count=1;char curr=s.charAt(0);
        st.push(curr);
        for(int i=1;i<s.length();i++){
            //System.out.println(count+" "+curr);
            if(count==0){count++;curr=s.charAt(i);st.push(curr);}
            else if(curr==s.charAt(i)){
                count++;
                if(count==k){
                    while(count!=1){
                        st.pop();count--;
                    }
                    count=0;
                    if(!st.isEmpty()){
                        curr=st.pop();
                        count=1;
                        while(!st.isEmpty() && curr==st.peek()){
                            count++;st.pop();
                        }
                        int c=count;
                        while(c!=0){c--;st.push(curr);}
                    }
                    
                }
                else{
                    st.push(curr);
                }
            }
            else{
                count=1;curr=s.charAt(i);
                st.push(curr);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}