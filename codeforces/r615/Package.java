package r615;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Package {

    static class Pair implements Comparable<Pair> {
        int x; int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        int n, t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        StringBuilder move = new StringBuilder();

        String sr = getStr('R');
        String su = getStr('U');

        while (n-- > 0) {
            t = Integer.parseInt(br.readLine());

            boolean valid = true;
            Pair[] a = new Pair[t];
            for (int i = 0; i < t; i++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                Pair p = new Pair(x, y);
                a[i] = p;
            }

            Arrays.sort(a);

            move.append(getRU(sr, a[0].x));
            move.append(getRU(su, a[0].y));

            for (int i = 1; i<t; i++) {
                if (a[i-1].x <= a[i].x && a[i-1].y <= a[i].y) {

                    int len = a[i].x - a[i-1].x;
                    move.append(getRU(sr, len));

                    len = a[i].y - a[i-1].y;
                    move.append(getRU(su, len));

                } else {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                ans.append("NO\n");
            } else {
                ans.append("YES\n");
                ans.append(move + "\n");
            }
            move.setLength(0);
            move = new StringBuilder();
        }
        System.out.println(ans);
    }

    private static String getStr(char ch) {
        int x = 1;
        StringBuilder sb = new StringBuilder();
        while (x < 1001) {
            sb.append(ch);
            ++x;
        }

        return sb.toString();
    }

    private static String getRU(String s, int len) {
        return s.substring(0, len);
    }
}
