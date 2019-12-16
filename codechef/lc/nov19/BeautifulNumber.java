package lc.nov19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulNumber {
    public static void main(String[] args) throws IOException {
        int t, n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            StringBuilder ss = new StringBuilder();
            StringBuilder es = new StringBuilder();

            for (int i = 0; i<n; i++) {
                ss.append(1);
                es.append(9);
            }

            long s = Long.parseLong(ss.toString());
            long e = Long.parseLong(es.toString());
            int[] sq = {1, 4, 9, 16, 25, 36, 49, 64, 81};
            for (long i = s; i<=e; i++) {
                long num = i, sum = 0;
                boolean inv = false;
                while (num > 0) {
                    int d = (int) (num % 10);
                    if (d == 0) {
                        inv = true; break;
                    }
                    sum += sq[d-1];
                    num /= 10;
                }
                if (!inv) {
                    boolean res = isPerfectSquare(sum);
                    if (res) {
                        System.out.println(i);
                        break;
                    }
                }
            }


        }
    }

    private static boolean isPerfectSquare(long n) {
        double root = Math.sqrt(n);
        return (root - Math.floor(root) == 0);
    }
}
