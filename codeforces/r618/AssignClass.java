package r618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AssignClass {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int l = 2 * n;
            String[] as = br.readLine().split(" ");
            int[] a = new int[l];
            for (int i=0; i<l; i++) a[i] = Integer.parseInt(as[i]);

            Arrays.sort(a);
            //System.out.println(Arrays.toString(a));
            System.out.println(a[n] - a[n-1]);
        }
    }
}
