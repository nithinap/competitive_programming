package lc.aug19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class DistApple {
    public static void main(String[] args) throws IOException {
        int t;
        BigInteger n, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] nk = br.readLine().split(" ");
            n = new BigInteger(nk[0]);
            k = new BigInteger(nk[1]);
            if (k.compareTo(BigInteger.ONE) == 0 || n.divide(k).mod(k).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
