package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnitGCD {
    public static void main(String[] args) throws IOException {
        int t;
        int SIZE = 200002;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n > 1) sb.append((int)Math.floor(n/2));
            else sb.append("1");
            sb.append("\n");
            if (n < 3) {
                sb.append(n + " ");
                for (int i=1; i<=n; i++) sb.append(i + " ");
                sb.append("\n");
            } else {
                sb.append("3 1 2 3\n");
                int k = n;
                if (n % 2 == 0) k = n - 2;
                for (int i=4; i<=k; i+=2) {
                    sb.append("2 " + i + " " + (i+1) + "\n");
                }
                if (k < n) sb.append("1 " + n + "\n");

            }
        }
        System.out.println(sb);
    }
}
