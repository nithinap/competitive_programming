package lc.oct18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteBit {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int d = (n/26);
            int r = n % 26;
            if (r == 0)
                d--;

            long p = (long)Math.pow(2, d);
            if (r > 0 && r <= 2) {
                System.out.println(p +" 0 0");
            } else if (r > 2 && r <= 10) {
                System.out.println("0 "+ p + " 0");
            } else {
                System.out.println("0 0 "+p);
            }
        }
    }
}
