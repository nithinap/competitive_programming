package lc.feb19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicJar {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            int[] a = new int[n];
            String[] as = br.readLine().split(" ");
            long sum =0;
            for (int i = 0; i<n; i++) {
                int a = Integer.parseInt(as[i]);
                sum += a;
            }

//            Arrays.sort(a);
            System.out.println(sum - (n-1));
        }
    }
}
