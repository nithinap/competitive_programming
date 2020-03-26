package edu.r80;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minimax {
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int best = 0, p1 = -1, p2 = -1;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int val = minmax(a[i], a[j], m);
                if (val > best) {
                    p1 = i;
                    p2 = j;
                    best = val;
                }
            }
        }
        //System.out.println("best" + best);
        System.out.println((p1+1) + " " + (p2+1));
    }

    private static int minmax(int[] a, int[] b, int m) {
        int min = 1000000001;
        for (int i=0; i<m; i++) {
            int tmp = Math.max(a[i], b[i]);
            min = Math.min(tmp, min);
        }
        return min;
    }
}
