package codeforces.r605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeFriends {
    public static void main(String[] args) throws IOException {
        int q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            String[] s = br.readLine().split(" ");
            int[] a = new int[3];
            a[0] = Integer.parseInt(s[0]);
            a[1] = Integer.parseInt(s[1]);
            a[2] = Integer.parseInt(s[2]);

            Arrays.sort(a);

            long d = a[1] - a[0] + a[2] - a[1] + a[2] - a[0];
            if (d == 0 || d == 2) {
                System.out.println(0);
            } else {
                System.out.println(d-4);
            }
        }
    }
}
