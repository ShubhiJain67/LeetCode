class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return nlogk(matrix,k);
    }
    private int n2logk(int[][] matrix, int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>((Integer a,Integer b)->{
            return b-a;
        });
        int count=0;
        for(int mat[] : matrix){
            for(int m:mat){
                queue.add(m);
                count++;
                if(count>k){
                    count--;
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    private int nlogk(int[][] matrix, int k){
        PriorityQueue<Pair> queue=new PriorityQueue<>((Pair a,Pair b)->{
            return matrix[a.i][a.j]-matrix[b.i][b.j];
        });
        for(int i=0;i<matrix.length;i++)
            queue.add(new Pair(i,0));
        while(k-->1){
            Pair p=queue.poll();
            if(p.j+1<matrix[0].length)
                queue.add(new Pair(p.i,p.j+1));            
        }
        Pair p=queue.poll();
        return matrix[p.i][p.j];
    }
}
