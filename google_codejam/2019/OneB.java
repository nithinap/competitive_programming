package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OneB {
    static class Pair implements Comparable<Pair> {
        int s;
        int e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            if (this != null && o != null)
                return this.s - o.s;
            else if (this == null && o != null) {
                return o.s;
            } else if (this != null && o == null) {
                return this.s;
            }
            return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] pq = br.readLine().split(" ");
            int p = Integer.parseInt(pq[0]);
            int q = Integer.parseInt(pq[1]);
            Pair[] Xpairs = new Pair[p];
            Pair[] Ypairs = new Pair[p];

            for (int k = 0; k < p; k++) {
                String[] sed = br.readLine().split(" ");
                int x = Integer.parseInt(sed[0]);
                int y = Integer.parseInt(sed[1]);
//                pairs[k] = sed()
                switch (sed[2]) {
                    case "N":
                        Ypairs[k] = new Pair(y + 1, q);
                        Xpairs[k] = new Pair(q + 1, q + 1);
                        break;
                    case "S":
                        Ypairs[k] = new Pair(0, y - 1);
                        Xpairs[k] = new Pair(q + 1, q + 1);
                        break;
                    case "E":
                        Ypairs[k] = new Pair(q + 1, q + 1);
                        Xpairs[k] = new Pair(x + 1, q);
                        break;
                    case "W":
                        Xpairs[k] = new Pair(0, x - 1);
                        Ypairs[k] = new Pair(q + 1, q + 1);
                        break;
                }

            }

            int[] valX = new int[q + 3];
            int[] valY = new int[q + 3];

//            System.out.println(Arrays.toString(Xpairs));
//            System.out.println(Arrays.toString(Ypairs));
            int resX = 0;
            int resY = 0;


            Arrays.sort(Xpairs);
            for (int k = 0; k < p; k++) {
                valX[Xpairs[k].s]++;
                valX[Xpairs[k].e + 1]--;
            }
            for (int k = 1; k <= q; k++) {
                valX[k] += valX[k - 1];
            }
            int max = Integer.MIN_VALUE;
            for (int k = 0; k <= q; k++) {
                if (max < valX[k]) {
                    max = valX[k];
                    resX = k;
                }
            }

            Arrays.sort(Ypairs);
            for (int k = 0; k < p; k++) {
//                System.out.println("=====" + Ypairs[k]);
                valY[Ypairs[k].s]++;
                valY[Ypairs[k].e + 1]--;
            }
            for (int k = 1; k <= q; k++) {
                valY[k] += valY[k - 1];
            }
            max = Integer.MIN_VALUE;
            for (int k = 0; k <= q; k++) {
                if (max < valY[k]) {
                    max = valY[k];
                    resY = k;
                }
            }

            System.out.println("Case #" + i + ": " + resX + " " + resY);
        }
    }
}
