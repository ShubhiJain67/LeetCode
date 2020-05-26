class Solution {
    public int[] sortArrayByParity(int[] A) {
        ArrayList<Integer> even=new ArrayList<>();
        ArrayList<Integer> odd=new ArrayList<>();
        int len=A.length;
        for(int i:A){
            if((i&1)==0)
                even.add(i);
            else
                odd.add(i);
        }
        A=new int[len];
        int i=0;
        for(int n:even)
            A[i++]=n;
        for(int n:odd)
            A[i++]=n;
        return A;
    }
}