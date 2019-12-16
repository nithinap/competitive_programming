package lc.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicChef {
    public static void main(String[] args) throws IOException {
        int t, n, x, s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] nxs = br.readLine().split(" ");
            n = Integer.parseInt(nxs[0]);
            x = Integer.parseInt(nxs[1]);
            s = Integer.parseInt(nxs[2]);

            int cur = x;
            for (int i=0; i<s; i++) {
                String[] ab = br.readLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                if (a == cur)
                    cur = b;
                else if (b == cur)
                    cur = a;
            }
            sb.append(cur+"\n");
        }

        System.out.println(sb.toString());
    }
}
