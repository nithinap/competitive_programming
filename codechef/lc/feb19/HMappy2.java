package lc.feb19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HMappy2 {
    public static void main(String[] args) throws IOException {
        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String[] c = br.readLine().split(" ");
            long n, a, b, k;
            n = Long.parseLong(c[0]);
            a = Long.parseLong(c[1]);
            b = Long.parseLong(c[2]);
            k = Long.parseLong(c[3]);

            double tot = 0;
            long gcd = computeGCD(a,b);
            long lcm = (a * b)/gcd;

            if (a != b)
                tot = Math.floor(n/a) + Math.floor(n/b) - 2 * Math.floor(n/(lcm));
            if (tot >= k) {
                System.out.println("Win");
            } else {
                System.out.println("Lose");
            }
        }
    }

    private static long computeGCD(long a, long b) {
        if (b == 0)
            return a;
        return computeGCD(b, a % b);
    }
}
