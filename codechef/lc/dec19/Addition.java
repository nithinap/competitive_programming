package lc.dec19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Addition {
    public static void main(String[] args) throws IOException {
        int a, b;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            int res = add(a, b);
            System.out.println(res);
        }
    }

    private static int add(int a, int b) {
        int steps = 0;
        while (b > 0) {
            int u = a ^ b;
            int v = a & b;
            a = u;
            b = v * 2;
            steps++;
            System.out.println("a: " + a + "| b:" + b );
        }
        System.out.println("s: " + steps);
        return a;
    }
}
