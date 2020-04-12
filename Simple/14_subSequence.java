import java.util.ArrayList;

class subSequence{
    public static void main(String[] args) {
        System.out.print("[");
        System.out.println(printSubSequence("abcdef", 0, ""));
        System.out.print("]");
        System.out.println(); 
        System.out.println();        
        ArrayList<String> res=returnSubSequence("abcdef");
        System.out.println(res.toString());
        System.out.println("Total number of substrings are -->"+res.size());
    }

    public static int printSubSequence(String str,int index,String answer){
        if(str.length()==index){
            System.out.print(answer+" ");
            return 1;
        }
        int count=0;
        count+=printSubSequence(str,index+1, answer);
        count+=printSubSequence(str,index+1, answer+str.charAt(index));
        return count;
    }

    public static ArrayList<String> returnSubSequence(String str){
        ArrayList<String> result=new ArrayList<>();
        if(str.length()==1){
            result.add(str);
        }
        else{
            char ch=str.charAt(0);
            ArrayList<String> resultRec=returnSubSequence(str.substring(1));
            for(String s:resultRec){
                result.add(s);
                result.add(ch+s);
            }            
        }
        return result;
    }
}