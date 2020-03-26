package lc.jan20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dynamo {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long a = Long.parseLong(br.readLine());

            long tot = (long)Math.pow(10, n);
            long s = a + 2L * tot;
            System.out.println(s);

            long b = Long.parseLong(br.readLine());
            System.out.println(tot-b);

            long d = Long.parseLong(br.readLine());
            System.out.println(tot-d);

            int res = Integer.parseInt(br.readLine());
            if (res != 1) return;
        }
    }
}
