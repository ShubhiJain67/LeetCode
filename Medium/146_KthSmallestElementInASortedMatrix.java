class Solution {
    public int kthSmallest(int[][] matrix, int k) {
		class Pair{ 
            int i;
            int j;
            Pair(int r, int c){
                this.i= r;
                this.j= c;
            }
        }
        
        Queue<Pair> heap = new PriorityQueue<>( (Pair a,Pair b) -> 
                                               matrix[a.i][a.j] - matrix[b.i][b.j]
                                              );
                                                 
        for(int j = 0; j < matrix[0].length && j < k ; j++){
            heap.add( new Pair(0, j) );
        }
        
        while( k > 1){
            Pair node = heap.poll();
            if( node.i +1 < matrix.length )
                heap.add(new Pair(node.i +1, node.j));
            k--;
        }
        
        return matrix[heap.peek().i][heap.peek().j];
        
    }
}