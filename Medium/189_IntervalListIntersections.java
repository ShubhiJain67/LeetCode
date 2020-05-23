class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0;
        int j=0;
        ArrayList<int []> list=new ArrayList<>();
        while(i<A.length && j<B.length){
            
            int add[]=new int[2];
            add[0]=Math.max(A[i][0],B[j][0]);
            add[1]=Math.min(A[i][1],B[j][1]);
            if(add[0]<=add[1])
                list.add(add);
            if(A[i][1]<B[j][1])
                i++;
            else
                j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}