package lc.jul19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MMax {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        BigInteger TWO = new BigInteger("2");

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            BigInteger n = new BigInteger(br.readLine());
            BigInteger k = new BigInteger(br.readLine());

            BigInteger kMinusN = k.subtract(n);
            // chocolates are lesser than people or equal to number of people
            if (kMinusN.compareTo(BigInteger.ZERO) <= 0) {
                BigInteger min = kMinusN.abs();
                int diff = min.compareTo(k);
                if (diff == 0){ // (k-n) == (n)
                    sb.append(k.multiply(TWO).subtract(BigInteger.ONE));
                } else if (diff < 0) {
                    sb.append(min.multiply(TWO));
                } else {
                    sb.append(k.multiply(TWO));
                }
            } else { // chocolates are in ample
                BigInteger kModN = k.mod(n);
                BigInteger min = n.subtract(kModN); // people with one less chocolate
                int diff = min.compareTo(kModN);

//                System.out.println("---- "+ kModN + ";" + min);
                if (kModN.compareTo(BigInteger.ZERO) == 0) {
                    sb.append(0);
                } else if (diff == 0) {
                    sb.append(kModN.multiply(TWO).subtract(BigInteger.ONE));
                } else if (diff < 0) {
                    sb.append(min.multiply(TWO));
                } else {
                    sb.append(kModN.multiply(TWO));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
