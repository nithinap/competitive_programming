package lc.jun20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefIce {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] as = br.readLine().split(" ");
            int r = 0;
            boolean f = false;
            for (int i=0; i<n; i++) {
                int v = Integer.parseInt(as[i]);
                if (r < (v - 5)) {
                    f = true;
                    break;
                }
                r += 5;
            }
            String res = f ? "NO" : "YES";
            System.out.println(res);
        }
    }
}
