package edu.r79;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class NewGarland {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int[] a = new int[3];
            a[0] = Integer.parseInt(s[0]);
            a[1] = Integer.parseInt(s[1]);
            a[2] = Integer.parseInt(s[2]);

            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            if ((a[2]-1) <= a[1]+a[0]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
