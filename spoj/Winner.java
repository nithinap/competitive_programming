package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Winner {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int[] ans = new int[100005];
            int k = 0;
            for (int i = 1; i<=c; i=c/(c/i) + 1) {
                ans[k++] = c / i;
            }

            System.out.println(k+1);

            StringBuilder sb = new StringBuilder();
            sb.append("0 ");
            for (int i=k-1; i>=0; i--) {
                sb.append(ans[i] + " ");
            }
            System.out.println(sb);
        }
    }
}
