package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeCandy {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] cs = br.readLine().split(" ");

            int sum = 0;
            for (int i=0; i<n; i++) {
                sum += Integer.parseInt(cs[i]);
            }

            if (sum <= k) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
