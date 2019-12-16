package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SweetProb {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] rgb = br.readLine().split(" ");
            int[] a = new int[3];
            a[0] = Integer.parseInt(rgb[0]);
            a[1] = Integer.parseInt(rgb[1]);
            a[2] = Integer.parseInt(rgb[2]);

            Arrays.sort(a);
            int res = a[0];

            int diff = a[2] - a[1];
            a[2] -= Math.min(a[0], diff);

            if (diff > a[0]) {
                res += Math.min(a[1], a[2]);
            } else {
                a[0] -= diff;
                a[1] -= a[0]/2;
                a[2] -= a[0]/2;
                if (a[0] % 2 == 1) a[1]--;
                res += Math.min(a[1], a[2]);

            }

            System.out.println(res);
        }
    }
}
