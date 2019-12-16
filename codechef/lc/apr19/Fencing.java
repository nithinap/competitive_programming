package lc.apr19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Fencing {
    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int t, n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] nmk = br.readLine().split(" ");
            n = Integer.parseInt(nmk[0]);
            m = Integer.parseInt(nmk[1]);
//            boolean[][] g = new boolean[n][m];
            Map<Integer, Set<Integer>> map = new HashMap<>();

            List<Pair> list = new LinkedList<>();
            for (int i=0; i<Integer.parseInt(nmk[2]); i++) {
                int r, c;
                String[] rc = br.readLine().split(" ");
                r = Integer.parseInt(rc[0]);
                c = Integer.parseInt(rc[1]);
//                g[r-1][c-1] = true;
                list.add(new Pair(r-1,c-1));
                if (map.containsKey(r-1)) {
                    Set<Integer> colSet = map.get(r - 1);
                    colSet.add(c-1);
                    map.put(r-1, colSet);
                } else {
                    Set<Integer> colSet = new HashSet<>();
                    colSet.add(c-1);
                    map.put(r-1, colSet);
                }
            }

//            for(int i=0; i<n; i++)
//                System.out.println(Arrays.toString(g[i]));

            long res = 0;
            for (Pair p: list) {
                if (p.row == 0) res++;
                else if(!(map.containsKey(p.row-1) && map.get(p.row-1).contains(p.col))) res++;
                /*if (!g[p.row - 1][p.col]) { // down
                    res++;
                }*/

                if (p.row == n - 1) res++;
                else if(!(map.containsKey(p.row+1) && map.get(p.row+1).contains(p.col))) res++;
                /*if (!g[p.row + 1][p.col]) { // up
                    res++;
                }*/

                if (p.col == 0) res++;
                else if(!(map.containsKey(p.row) && map.get(p.row).contains(p.col-1))) res++;
                /*if (!g[p.row][p.col - 1]) { // left
                    res++;
                }*/

                if (p.col == m - 1) res++;
                else if(!(map.containsKey(p.row) && map.get(p.row).contains(p.col+1))) res++;
                /*if (!g[p.row][p.col + 1]) { // right
                    res++;
                }*/
            }
            System.out.println(res);
        }
    }
}
