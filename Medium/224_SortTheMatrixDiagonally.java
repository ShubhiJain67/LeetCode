class Solution {
    public int[][] diagonalSort(int[][] a) {
        int m = a.length, n = a[0].length;
        int i,j,k=-1;
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        while(k < m) {
            i = k;j = -1;
            while(i+1 < m && j+1 < n) {
                p.add(a[i+1][j+1]);
                i++;j++;
            }
            i = k;j = -1;
            while(i+1 < m && j+1 < n) {
                a[i+1][j+1] = p.poll();
                i++;j++;
            }
            k++;
        }
        
        k = 0;
        while(k < n) {
            j = k;i = -1;
            while(i+1 < m && j+1 < n) {
                p.add(a[i+1][j+1]);
                i++;j++;
            }
            j = k;i = -1;
            while(i+1 < m && j+1 < n) {
                a[i+1][j+1] = p.poll();
                i++;j++;
            }
            k++;
        }
        
        return a;
    }
}