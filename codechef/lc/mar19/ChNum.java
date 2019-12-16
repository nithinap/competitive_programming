package lc.mar19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChNum {

    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] astr = br.readLine().split(" ");
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(astr[i]);
            }

            int po = 0, ne = 0;
            for (int i=0; i<n; i++) {
                if (a[i] > 0) po++;
                else ne++;
            }

            if (po > ne) {
                if (ne == 0) ne = po;
                System.out.println(po+ " " + ne);
            } else {
                if (po == 0) po = ne;
                System.out.println(ne + " "+ po);
            }
        }
    }
}
