package r619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AyuFunc {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);


            long res = solve(n, m);
            System.out.println(res);
        }
    }

    private static long solve(int n, int m) {
        if (m == 0 || n == 0) return 0;
        long res = m;

        res *= (n - 1);
        int c0 = n - m;
        int v = (c0 >= m - 1) ? m : m - c0;
        res += 2L * v;
        return res;
    }
}
