package edu.r79;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerseSanta {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] ns = br.readLine().split(" ");
            int n = Integer.parseInt(ns[0]);
            int s = Integer.parseInt(ns[1]);

            int[] a = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int i = 1, max = a[0], maxi = 0, len = 0, psum = a[0], ind = -1;
            if (a[0] <= s) len = 1;
            else ind = 0;

            while (i < n) {
                if (a[i] > max) {
                    max = a[i];
                    maxi = i;
                }
                psum += a[i];
                if (psum <= s) {
                    len = i+1;
                } else if (psum - max <= s && len > i) {
                    len = i;
                    ind = maxi;
                }
                //psum += a[i];
                i++;
            }

            //System.out.println("len: " + len);

            int res = (ind == -1) ? 0 : ind+1;
            System.out.println(res);

        }
    }
}
