package lc.feb19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepChef {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] as = br.readLine().split(" ");
            String[] bs = br.readLine().split(" ");

            int[] a = new int[n];
            int[] d = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(as[i]);
            }

            for (int i=0; i<n; i++) {
                d[i] = Integer.parseInt(bs[i]);
            }

            int[] res = new int[n];
            res[0] = d[0] - a[1] - a[n-1];
            res[n-1] = d[n-1] - a[n-2] - a[0];
            for (int i = 1; i<n-1; i++) {
                res[i] = d[i] - a[i-1] - a[i+1];
            }

            int max = -1;
            for (int i = 0; i<n; i++) {
                if (res[i] > 0 && d[i] > max) {
                    max = d[i];
                }
            }
            System.out.println(max);

        }
    }
}
