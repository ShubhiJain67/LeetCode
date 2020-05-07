class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text.length()<7) return 0;
        int []balloon=new int[5];
        int b=0,a=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch=='b') b++;
            else if(ch=='a') a++;
            else if(ch=='l') l++;
            else if(ch=='o') o++;
            else if(ch=='n') n++;
        }
        int min=Integer.MAX_VALUE;
        if(min>b){
            min=b;}
        if(min>a)
            min=a;
        if(min>(l>>>1))
            min=(l>>>1);
        if(min>(o>>>1))
            min=(o>>>1);
        if(min>n)
            min=n;
        return min;
        
    }
}