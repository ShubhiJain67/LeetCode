import java.util.LinkedList;

class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
        rooms = wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

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

    public static int[][] wallsAndGates(int[][] rooms) {
        // write your code here

        LinkedList<pair> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.addLast(new pair(i, j, 0));
                }
            }
        }

        while (queue.size() != 0) {
            pair vertex = queue.removeFirst();
            for (int d = 0; d < dir.length; d++) {
                int r = vertex.i + dir[d][0];
                int c = vertex.j + dir[d][1];
                if (r >= 0 && c >= 0 && r < rooms.length && c < rooms[0].length && rooms[r][c] == 2147483647) {
                    queue.addLast(new pair(r, c, vertex.level + 1));
                    rooms[r][c] = vertex.level + 1;
                }
            }
        }
        return rooms;
    }

}