package kickstart2020.roundA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Allocation {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        for (int k=1; k<=t; k++) {
            String[] nb = br.readLine().split(" ");
            int n = Integer.parseInt(nb[0]);
            int b = Integer.parseInt(nb[1]);

            String[] as = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(as[i]);
            }
            Arrays.sort(a);
            long s = 0, res = 0;
            for (int i=0; i<n; i++) {
                if (s + a[i] <= b) {
                    s += a[i];
                    res = i+1;
                } else
                    break;
            }

            System.out.println("Case #" + k + ": " + res);
        }
    }
}
