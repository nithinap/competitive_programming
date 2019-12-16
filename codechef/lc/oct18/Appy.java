package lc.oct18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Appy {
    public static void main(String[] args) throws IOException {
        int n;
        long m;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Long.parseLong(nm[1]);
        String[] astr = br.readLine().split(" ");
        String[] bstr = br.readLine().split(" ");
        long[] a = new long[n];
        long[] b = new long[n];

        for (int i=0; i<n; i++)
            a[i] = Long.parseLong(astr[i]);
        for (int i=0; i<n; i++)
            b[i] = Long.parseLong(bstr[i]);

        long low = 0;
        long high = a[0] * b[0];

        for (int i = 1; i < n; i++) {
            long tmp = a[i] * b[i];
            if (tmp > high) {
                high = tmp;
            }
        }

        long res = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long bal = 0;
            for (int i = 0; i < n; i++) {
                long days = 0;
                if (b[i] != 0) {
                    days = (long) (mid / b[i]);
                    bal += (a[i] > days && days>=0) ? (a[i] - days) : 0;
                }
            }
//            System.out.println("low: "+low+"; high:" +high+"; mid: "+mid+"; ");
            if (bal > m) {
                low = mid+1;
            } else {
                if (res > mid && bal >= 0)
                    res = mid;
                high = mid-1;
            }
        }
        System.out.println(res);
    }
}
