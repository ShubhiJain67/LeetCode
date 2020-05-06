class Solution {
    public List <Integer> spiralOrder(int[][] matrix) {
        //------------if no element exists int the matrix---------
        if (matrix.length == 0) return  new ArrayList();;
        List<Integer> ans = new ArrayList<>();
        
        // to keep the boundary values of the spiral
        int ri = 0;
        int rj = matrix.length - 1;
        int ci = 0;
        int cj = matrix[0].length - 1;
        while (ri <= rj && ci<= cj) {
            
            //--------traversing left to right of spiral---------
            for (int c = ci; c <= cj; c++) 
                ans.add(matrix[ri][c]);
            //-----------traversing top to bottom of spiral--------
            for (int r = ri + 1; r <= rj; r++) 
                ans.add(matrix[r][cj]);
           
            //to check if any more elements are left or not
            if (ri < rj && ci < cj) {
                //------------traversing right to left of spiral---------
                for (int c = cj - 1; c > ci; c--) 
                    ans.add(matrix[rj][c]);
                //-------------traversing bottom to top of spiral------------
                for (int r = rj; r > ri; r--) 
                    ans.add(matrix[r][ci]);
            }
            //-------updating the boundaries of the new inner spiral to be traversed-------
            ri++;
            rj--;
            ci++;
            cj--;
        }
        return ans;
    }
}