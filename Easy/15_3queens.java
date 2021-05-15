class ArrangeNPeople{
    public static void main(String[] args) {
        System.out.println(printNPeople(0,7,0,5,""));
    }

    public static int printNPeople(int b,int boxes,int q,int queens,String answer){
        if(q==queens){
            System.out.println(answer);
            return 1;
        }
        if(b==boxes || boxes-b<queens-q){
            return 0;
        }
        int count=0;
        count+=printNPeople(b+1,boxes,q+1,queens,answer+"b"+b+"q"+q+" ");
        count+=printNPeople(b+1,boxes,q,queens,answer);
        return count;
    }
}