package r617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class WalkBot {
    static class Pair {
        int x;
        int y;

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
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();
            if (len == 1) {
                System.out.println("-1");
            } else {
                boolean found = false;
                for (int i = 1; i < len; i++) {
                    String t2 = s.substring(i-1, i+1);
                    if (t2.equals("LR") || t2.equals("RL") || t2.equals("UD") || t2.equals("DU")) {
                        System.out.println(i + " " + (i+1));
                        found = true;
                        break;
                    }
                }

                String res = "";
                if (!found) {
                    Map<Pair, Integer> pos = new HashMap<>();
                    pos.put(new Pair(0, 0), 1);
                    int ml = Integer.MAX_VALUE;


                    int x = 0, y = 0;
                    for (int i = 0; i < len; i++) {
                        if (s.charAt(i) == 'L') x--;
                        else if (s.charAt(i) == 'R') x++;
                        else if (s.charAt(i) == 'U') y++;
                        else y--;
                        Pair cur = new Pair(x, y);
                        if (pos.containsKey(cur)) {
                            int clen = i+1 - pos.get(cur);
                            if (clen == 2) break;
                            if (clen < ml) {
                                res = pos.get(cur) + " " + (i + 1);
                                ml = clen;
                            }
                            found = true;
                        } else {
                            pos.put(cur, i+1);
                        }
                    }
                }

                if (!found) System.out.println("-1");
                else {
                    System.out.println(res);
                }
            }
        }
    }
}
