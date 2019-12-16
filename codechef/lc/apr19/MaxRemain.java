package lc.apr19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxRemain {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(b.readLine());
        String[] sta = b.readLine().split(" ");
        int[] a = new int[n];


        a[0] = Integer.parseInt(sta[0]);
        int max = a[0];
        int max2 = 0;
        for(int i=1; i<n; i++) {
            a[i] = Integer.parseInt(sta[i]);
            if (a[i] > max) {
                max2 = max;
                max = a[i];
            } else if (a[i] != max && a[i] > max2) {
                max2 = a[i];
            }
        }
//        System.out.println(max + " " + max2);
        System.out.println(max2%max);
    }
}
