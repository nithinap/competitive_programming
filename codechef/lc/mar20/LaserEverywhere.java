package lc.mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LaserEverywhere {
    static class Query implements Comparable<Query> {
        int ind;
        int x1;
        int x2;
        int y;

        public Query(int ind, int x1, int x2, int y) {
            this.ind = ind;
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }


        @Override
        public String toString() {
            return "Q{" +
                    "ind=" + ind +
                    ", x1=" + x1 +
                    ", x2=" + x2 +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Query o) {
            if (this.y == o.y) return (this.x1 - o.x1);
            else return (this.y - o.y);
        }
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nq = br.readLine().split(" ");
            int n = Integer.parseInt(nq[0]);
            int q = Integer.parseInt(nq[1]);

            int[] y = new int[n];
            String[] ystr = br.readLine().split(" ");
            for (int i=0; i<n; i++) y[i] = Integer.parseInt(ystr[i]);

            // till any xi there will i-1 lines

            Query[] qarr = new Query[q];
            // process queries
            for (int i=0; i<q; i++) {
                String[] qs = br.readLine().split(" ");

                qarr[i] = new Query(i, Integer.parseInt(qs[0]), Integer.parseInt(qs[1]), Integer.parseInt(qs[2]));
            }
            Arrays.sort(qarr);
            System.out.println(Arrays.toString(qarr));

            int[] qres = new int[n];
            for (int i=0; i<ystr.length; i++) {
                qres[i] = bSearch(qarr, y[i], 0, qarr.length-1);
            }

            int res[] = new int[q];
            for (int i=1; i<n; i++) {
                int st = qres[i-1], end = qres[i];
                if (st == -1 && end == -1) continue;
                if (st == -1) st = end;
                if (end == -1) end = st;

                for (int k = st; k<=end; k++) {
                    int xmin = i, xmax = i+1;
                    if (qarr[k].x1>= xmin && qarr[k].x2 <= xmax) res[k]++;
                }
            }


            int[] out = new int[q];
            for (int i=0; i<q; i++) {
                out[qarr[i].ind] = res[i];
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<q; i++) {
                sb.append(out[i] + "\n");
            }
            System.out.print(sb);
        }
    }

    private static int bSearch(Query[] qarr, int key, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (qarr[mid].y >= key) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (qarr[lo].y == key) ? lo : -1;
    }
}
