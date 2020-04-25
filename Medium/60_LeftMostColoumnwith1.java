/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix matrix) {
        List<Integer> dim=matrix.dimensions();
        if(dim.get(0)==0) return -1;
	    int i=dim.get(0)-1;
        int j = dim.get(1)-1;
	    while(i>=0 && j>=0){
		    if(matrix.get(i,j) == 0) i--;
		    else j--;
	    }
	    return j==dim.get(1)-1?-1:j+1;
    }
     public int correctButMoreNumberOfCalls(BinaryMatrix matrix) {
        List<Integer> dim=matrix.dimensions();
        int sum[]= new int[dim.get(0)];
        for(int j=0;j<dim.get(1);j++){
            for(int i=0;i<dim.get(0);i++){
                sum[i]+=matrix.get(i,j); 
            } 
        }
        int max=0;
        for(int i=0;i<dim.get(0);i++){
            if(sum[i]>max){
                max=sum[i];
            }
        }
        if(max==0) return -1;
        return dim.get(1)-max;
    }
    
}