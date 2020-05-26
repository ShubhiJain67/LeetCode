import java.util.ArrayList;

class permutation{
    public static void main(String[] args) {
        System.out.println(returnPermutationWithDuplicates("abca").toString());
        System.out.println(returnPermutationWithoutDuplicates("abca").toString());
    }

    public static ArrayList<String> returnPermutationWithDuplicates(String str){
        if(str.length()==1){
            ArrayList<String> ar=new ArrayList<>();
            ar.add(str);
            return ar;
        }
            char ch=str.charAt(0);
            ArrayList<String> RecAns=returnPermutationWithDuplicates(str.substring(1));
            // System.out.println(RecAns.toString());
            ArrayList<String> answer=new ArrayList<>();
            for(String s:RecAns){
                answer.add(ch+s);
                for(int i=1;i<s.length();i++){
                    answer.add(s.substring(0, i)+ch+s.substring(i));
                }
                answer.add(s+ch);
            }
            return answer;
    }

    public static int printPermutationWithDuplicates(Striing str,String answer){
        int count=0;
        if(str.length()==1){
            
        }
        return count;
    }
    
    public static ArrayList<String> returnPermutationWithoutDuplicates(String str){
        if(str.length()==1){
            ArrayList<String> ar=new ArrayList<>();
            ar.add(str);
            return ar;
        }
            char ch=str.charAt(0);
            ArrayList<String> RecAns=returnPermutationWithoutDuplicates(str.substring(1));
            System.out.println(RecAns.toString());
            ArrayList<String> answer=new ArrayList<>();
            for(String s:RecAns){
                if(!answer.contains(ch+s)){
                    // System.out.println("Entered outer 1 condition with "+ ch+s);
                    answer.add(ch+s);
                }
                for(int i=1;i<s.length();i++){
                    if(!answer.contains(ch+s)){
                        // System.out.println("Entered in condition with "+ s.substring(0, i)+ch+s.substring(i));
                        answer.add(s.substring(0, i)+ch+s.substring(i));
                    }
                    
                }
                if(!answer.contains(s+ch)){
                    // System.out.println("Entered outer 2 condition with "+ s+ch);
                    answer.add(s+ch);
                }
            }
            return answer;

    }

}