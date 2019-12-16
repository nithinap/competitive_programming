package challenges.truecaller;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Cell class representing a cell on chequer board.
 */
class Cell {
    int x;
    int y;
    Queue<Cell> path;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
       path = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }
}


public class ChequerBoard {
    int size;
    Cell[] carr;

    static int[] xmoves = {0, 0, 3, -3, 2, 2, -2, -2};
    static int[] ymoves = {3, -3, 0, 0, 2, -2, 2, -2};

    ChequerBoard(int size) {
        this.size = size;
        carr = new Cell[size * size];
    }

    int findPaths(Cell src) {
        carr[0] = src;
        // add src cell to its path
        src.path.add(src);

        boolean[][] visited = new boolean[size][size];
        Queue<Cell> queue = new LinkedList<>();

        queue.add(src);
        visited[src.x][src.y] = true;
        int totalVisited = 1;
        int m = 1;

        while(!queue.isEmpty()) {
            Cell curr = queue.poll();

            int x, y;
            for (int i=0; i<xmoves.length; i++) {
                x = curr.x + xmoves[i];
                y = curr.y + ymoves[i];
                if (isValid(x, y, size) && !visited[x][y]) {
                    visited[x][y] = true;
                    totalVisited++;

                    Cell dest = new Cell(x, y);
                    dest.path.addAll(curr.path);
                    dest.path.add(dest);
                    queue.add(dest);
                    carr[m++] = dest;

                    if (totalVisited == 100) {
//                        System.out.println("traced all");
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isValid(int x, int y, int size) {
        if (x >= 0 && x < size && y >= 0 && y < size)
            return true;
        return false;
    }

    public Cell[] getCarr() {
        return carr;
    }
}
