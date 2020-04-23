import java.util.LinkedList;

class Solution {
    class pair {
        int i;
        int j;
        int level;

        pair(int i, int j, int l) {
            this.i = i;
            this.j = j;
            this.level = l;
        }
    }

    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        LinkedList<pair> queue = new LinkedList<>();
        queue.addLast(new pair(0, 0, 1));
        grid[0][0] = 1;
        while (queue.size() != 0) {
            pair vertex = queue.removeFirst();
            if (vertex.i == grid.length - 1 && vertex.j == grid[0].length - 1) {
                return vertex.level;
            }
            for (int d = 0; d < dir.length; d++) {
                int r = vertex.i + dir[d][0];
                int c = vertex.j + dir[d][1];
                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0) {
                    System.out.println(r + " " + c);
                    queue.addLast(new pair(r, c, vertex.level + 1));
                    grid[r][c] = 1;
                }
            }
        }
        return -1;
    }

}