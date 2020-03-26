package r622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FastFood {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t =Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            int c = Integer.parseInt(st[2]);

            int res = solve(a, b, c);
            System.out.println(res);
        }
    }


    private static int swap(int a, int b) {
        return a;
    }

    private static int solve(int a, int b, int c) {
        if (a < b) a = swap(b, b = a);
        if (a < c) a = swap(c, c = a);
        if (b < c) b = swap(c, c = b);

        //System.out.println(a + " " + b + " " + c);
        int out = 0;

        if (a > 0) out++; a--;
        if (b > 0) out++; b--;
        if (c > 0) out++; c--;

        if (a > 0 && b >0) {
            out++;
            a--; b--;
        }

        if (a > 0 && c > 0) {
            out++;
            a--; c--;
        }

        if (b > 0 && c >0) {
            out++;
            b--; c--;
        }

        if (a > 0 && b >0 && c >0) {
            out++;
            b--; c--;
        }
        return out;
    }
}
