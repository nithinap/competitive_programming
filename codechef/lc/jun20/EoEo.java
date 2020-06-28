package lc.jun20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EoEo {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            long r = solve(n);
            System.out.println(r);
        }
    }

    private static long solve(long n) {
        if (n == 1) return 0;
        if (n % 2 == 1) return n/2;
        if ((n & (n-1)) == 0) return 0;

        long r = getV(n);
        return r;
    }

    private static long getV(long n) {
        int r = 0;
        while (n % 2 == 0) {
            n /= 2;
            ++r;
        }
        return n / 2;
    }
}
