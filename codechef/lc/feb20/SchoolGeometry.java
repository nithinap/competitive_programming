package lc.feb20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SchoolGeometry {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            String[] as = br.readLine().split(" ");
            String[] bs = br.readLine().split(" ");
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(as[i]);
            for (int i=0; i<n; i++) b[i] = Integer.parseInt(bs[i]);

            Arrays.sort(b);

            long ans = 0;
            for (int i=0; i<n; i++) {
                //System.out.println(a[i] + " " + b[i]);
                ans += Math.min(a[i], b[i]);
            }

            System.out.println(ans);
        }
    }
}
