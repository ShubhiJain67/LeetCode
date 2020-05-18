public class Solution {

    public String complexNumberMultiply(String a, String b) { 
        int n1=0,n2=0,c1=0,c2=0;
       for(int i=0;i<a.length();i++){
           if(a.charAt(i)=='+'){
               n1=Integer.valueOf(a.substring(0,i));
               c1=Integer.valueOf(a.substring(i+1,a.length()-1));
           }
       }
        for(int i=0;i<b.length();i++){
           if(b.charAt(i)=='+'){
               n2=Integer.valueOf(b.substring(0,i));
               c2=Integer.valueOf(b.substring(i+1,b.length()-1));
           }
       }
        // System.out.println(n1+" "+n2+" "+c1+" "+c2);
        return (n1*n2-c2*c1)+"+"+(n1*c2+n2*c1)+"i";
    }
}
