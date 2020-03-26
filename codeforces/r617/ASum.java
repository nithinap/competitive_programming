package r617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASum {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] as = br.readLine().split(" ");

            long sum = 0;
            int even = 0;
            int odd = 0;
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(as[i]);
                sum += a[i];
                if (a[i] % 2 == 0) even++;
                else odd++;
            }

            if (sum % 2 == 1) {
                System.out.println("YES");
            } else {
                if (odd%2 == 0 && odd == n) {
                    System.out.println("NO");
                } else if (n % 2 == 1 && odd > 0){
                    System.out.println("YES");
                } else if (odd > 0 && even > 0){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
