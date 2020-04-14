package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CarSell {
    private static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(s[i]);
            Arrays.sort(a);

            long sum = 0;
            int k = 0;
            for (int i=n-1; i>=0; i--) {
                int v = (a[i] >= k) ? (a[i] - k) : 0;
                sum = (sum +  v) % MOD;
                k++;
            }
            System.out.println(sum);
        }
    }
}
