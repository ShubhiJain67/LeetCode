class Solution {
    public String find(String str){
        int count=1;
        String ans="";
        // System.out.println("find"+str);
        for(int i=1;i<str.length();i++){
            // System.out.println(str.charAt(i-1)+" "+str.charAt(i));
            if(str.charAt(i-1)==str.charAt(i)){
                count++;
                 // System.out.println(count+" "+Integer.toString(count)+str.charAt(i-1));
            }           
            else{
                if(count!=1){
                    ans+=(Integer.toString(count)+str.charAt(i-1));
                    count=1;
                }
                else{
                    ans+=("1"+str.charAt(i-1));
                }
            }
        }
        if(count!=1){
                    ans+=(Integer.toString(count)+str.charAt(str.length()-1));
                    count=1;
                }
                else{
                    ans+=("1"+str.charAt(str.length()-1));
                }
        // System.out.println("FindAns"+ans);
        return ans;
    }
    public String countAndSay(int n) {
        String ans[]=new String[31];
        ans[0]="";
        ans[1]="1";
        ans[2]="11";
        for(int i=3;i<=n;i++){
            ans[i]=find(ans[i-1]);
        }
        // for(int i=0;i<=n;i++){
        //     System.out.println(ans[i]);
        // }
        return ans[n];
    }
}