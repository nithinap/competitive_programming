package lc.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TableGame {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            String m = br.readLine();
            String n = br.readLine();

            int col = m.length() + 1;
            int row = n.length() + 1;
            int[][] grid = new int[row][col];

            for (int i=0; i<col-1; i++) {
                grid[0][i+1] = m.charAt(i) - '0'; // 1 loose 0 win
            }

            for (int i=0; i<row-1; i++) {
                grid[i+1][0] = n.charAt(i) - '0';
            }

            grid[0][0] = Integer.MIN_VALUE;
            for (int i=1; i<row; i++) {
                for (int j=1; j<col; j++) {
                    if (grid[i-1][j] == 0 || grid[i][j-1] == 0)
                        grid[i][j] = 1;
                    else
                        grid[i][j] = 0;
                }
            }

//            printMat(grid, row, col);

            int q;
            q = Integer.parseInt(br.readLine());

            while (q-- > 0) {
                String[] xy = br.readLine().split(" ");

                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                if (grid[x-1][y] == 0 || grid[x][y-1] == 0)
                    sb.append("1");
                else
                    sb.append("0");
            }

            sb.append("\n");
    }
        System.out.println(sb.toString());
}

    private static void printMat(int[][] grid, int row, int col) {
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
