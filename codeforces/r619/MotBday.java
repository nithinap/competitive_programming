package r619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MotBday {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] as = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++)
                a[i] = Integer.parseInt(as[i]);

            solve(a, n);

        }

    }

    private static void solve(int[] a, int n) {
        int[] out = new int[n];
        long num = 0;

        int i = 0;
        while (i<n && a[i] == -1) i++;

        //int y = 0;
        if (i < n) {
            int l = i, r = i;
            for (; i < n; i++) {
                if (a[i] != -1) {
                    if (l < r) {
                        long v = (a[l] + (long) a[i]) / 2;

                        if (num > 0) {
                            long max1 = Math.max(Math.abs(num - a[l]), Math.abs(num - a[i]));
                            long max2 = Math.max(Math.abs(v - a[l]), Math.abs(v - a[i]));

                            if (max1 > max2) num = (num + v) / 2;
                        }
                        else {
                            num = v;
                            //y = Math.max(y, Math.max(Math.abs(y - a[i]), Math.abs(y-a[l])));
                        }
                        r = i;
                        l = i;
                    }
                    l = i;

                }
                else {
                    r = i;
                }
            }
        }


        for (i=0; i<n; i++) {
            if (a[i] == -1) a[i] = (int)num;
        }


        int max = -1;
        for (i=1; i<n; i++) {
            max = Math.max(max, Math.abs(a[i] - a[i-1]));
        }

        System.out.println(max + " " + num);

    }
}
