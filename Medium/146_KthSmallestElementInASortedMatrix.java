class Solution {
    public int kthSmallest(int[][] matrix, int k) {
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
}
