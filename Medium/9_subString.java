import java.util.*;
class subString{
    public static void main(String[] args) {
        ArrayList<String> res=returnSubStr("abcdef");
        System.out.println(res.toString());
        System.out.println("Total number of substrings are -->"+res.size());
        System.out.println();
        System.out.println(printSubStr("abcdef", ""));
    }
    
    public static ArrayList<String> returnSubStr(String str){
        ArrayList<String> result=new ArrayList<>();
        if(str.length()==1){
            result.add(str);
        }
        else{
            char ch=str.charAt(0);
            ArrayList<String> resultRec=returnSubStr(str.substring(1));
            result.addAll(resultRec);
            for(String s:resultRec){
                result.add(ch+s);
            }            
        }
        return result;
    }

    public static int printSubStr(String str,String answer){
        int count=0;
        if(str.length()==0){
            System.out.println(answer);
            return 0;
        }
        if(str.length()==1){
            count=1;
        }
            count+=printSubStr(str.substring(1),answer+str.charAt(0));
            count+=printSubStr(str.substring(1),answer);       
        
        return count;
    }

}