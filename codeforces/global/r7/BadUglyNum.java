package global.r7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BadUglyNum {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        if (n == 1) return "-1";
        if (n == 2) return "23";

        StringBuilder sb = new StringBuilder();

        int lim = n/2;
        if (n % 2 == 0) lim--;
        for (int i=0; i<lim; i++) {
            sb.append("23");
        }

        if (n%2 == 0) {
            if ((5 * (lim+1)) % 3 == 0) {
                sb.append("33");
            } else {
                sb.append("23");
            }
        } else {
            if ((5*lim + 3) % 3 == 0) {
                sb.replace(sb.length()-2, sb.length(), "33");
                sb.append("3");
            } else
            sb.append("3");
        }

        return sb.toString();
    }

}
