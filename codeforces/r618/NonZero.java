package r618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonZero {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] as = br.readLine().split(" ");
            int[] a = new int[n];
            int sum = 0, c = 0;
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(as[i]);
                sum += a[i];
                if (a[i] == 0) c++;
            }

            int res = 0;
            if (c == 0 && sum == 0) {
                System.out.println(1);
            } else {
                res = c;
                if (sum + c == 0) res++;
                System.out.println(res);
            }
        }
    }
}
