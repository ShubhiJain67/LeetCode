class Solution {
    public static class pair {
        int i;
        int j;
        int level;

        pair(int i, int j, int l) {
            this.i = i;
            this.j = j;
            this.level = l;
        }
    }

    public static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] matrix) {
        LinkedList<pair> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * -1;
                if (matrix[i][j] == 0) {
                    queue.addLast(new pair(i, j, 0));
                }
            }
        }

        while (queue.size() != 0) {
            pair vertex = queue.removeFirst();
            for (int d = 0; d < dir.length; d++) {
                int r = vertex.i + dir[d][0];
                int c = vertex.j + dir[d][1];
                if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && matrix[r][c] == -1) {
                    queue.addLast(new pair(r, c, vertex.level + 1));
                    matrix[r][c] = vertex.level + 1;
                }
            }
        }
        return matrix;
    }
}