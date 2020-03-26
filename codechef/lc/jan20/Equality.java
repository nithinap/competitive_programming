package lc.jan20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equality {
    static class Pair implements Comparable<Pair> {
        int s, e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return s == pair.s &&
                    e == pair.e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }

        @Override
        public int compareTo(Pair o) {
            if (this.s < o.s) return this.s - o.s;
            else return this.e - o.e;
        }

        @Override
        public String toString() {
            return "P{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        String[] st = br.readLine().split(" ");

        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st[i]);
        }

        Pair[] ip = getIncPairs(a, n);
        Pair[] dp = getDecPairs(a, n);

        //System.out.println(Arrays.toString(ip));
        //System.out.println(Arrays.toString(dp));

        // ans q queries
        for (int i=0; i<q; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            --l; --r;
            int c1 = countInRange(ip, l, r);
            int c2 = countInRange(dp, l, r);
            //System.out.println("c1: " + c1 + "; c2: " +c2);

            //System.out.println(incPairs[l] + " " + incPairs[r]);
            //int ic = 0, dc = 0;

            //System.out.println(l + " " + r + " ;" + c1+ "  " + c2);
            String res = (c1 == c2) ? "YES" : "NO";
            System.out.println(res);

        }

    }

    private static void fillPairs(Pair[] pairs, int u, int l) {
        for (int i=u; i>=l; i--) {
            Pair pi = pairs[i];
            if (pi != null) {
                int s = pi.s;
                for (int j = i-1; j>=s; j--) {
                    pairs[j] = pi;
                }
                i = s;
            }
        }
    }

    private static Pair[] getDecPairs(int[] a, int n) {
        int s = 0, e = 0;
        List<Pair> dec = new ArrayList<>();
        for (int i=1; i<n; i++) {
            if (a[i-1] > a[i]) e = i;
            else {
                if (s < e) {
                    Pair p = new Pair(s, e);
                    dec.add(p);
                }
                s = i;
                e =i;
            }
        }
        if (s < e) dec.add(new Pair(s,e));
        return dec.toArray(new Pair[dec.size()]);
    }

    private static Pair[] getIncPairs(int[] a, int n) {
        int s = 0, e = 0;
        List<Pair> inc = new ArrayList<>();
        for (int i=1; i<n; i++) {
            if (a[i-1] < a[i]) e = i;
            else {
                if (s < e) {
                    Pair p = new Pair(s, e);
                    inc.add(p);
                }
                s = i;
                e =i;
            }
        }
        if (s < e) inc.add(new Pair(s,e));
        return inc.toArray(new Pair[inc.size()]);
    }

    private static int bsLeft(Pair[] p, int l, int h, int key) {
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l)/2;
            if (p[mid].s == key) return mid;
            else if (p[mid].s > key) {
                h = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    private static int bRight(Pair[] p, int l, int h, int key) {
        int ans = p.length;
        while (l <= h) {
            int mid = l + (h - l)/2;
            if (p[mid].e == key) return mid;
            else if (p[mid].e < key) {
                l = mid + 1;
            } else {
                ans = mid;
                h = mid - 1;
            }
        }
        return ans;
    }

    private static int countInRange(Pair[] p, int l, int r) {
        if (p.length == 0) return 0;
        // check if out of bound
        if (p[p.length - 1].e <= l) return 0;
        if (p[0].s >= r) return 0;

        int left = bsLeft(p, 0, p.length-1, l);
        int right = bRight(p, 0, p.length-1, r);

        //System.out.println("------");
        //System.out.println(Arrays.toString(p));
        //System.out.println(left + " " + right);
        //System.out.println("------");

        // left has max ind of pair such that p.s <= L
        // right has max ind of pair such that p.e <= R
        if (right <p.length && p[right].s >= r) right--;
        if (p[left].e <= l) left++;


        //System.out.println("("+left + " " + right);
        if (right == p.length && left >= 0) return p.length - left;
        //if (left == right && left == -1) return 0;
        if (left > right) return 0;
        return right - left + 1;
    }
}
