class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int i=0;
        for( ;i<matrix.length-1;i++){
            if(target==matrix[i][0] || target==matrix[i+1][0]) 
                return true;
            if(target>matrix[i][0]&& target<matrix[i+1][0])
                break;
            
        }
        // System.out.println(i);
        int low=0;
        int high=matrix[0].length-1;
            
        while(low<=high){
            int mid=(low+high)/2;
            // System.out.println(mid);
            if(matrix[i][mid]==target) return true;
            else if(matrix[i][mid]>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}