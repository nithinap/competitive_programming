package lc.mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XOREngine {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nq = br.readLine().split(" ");
            int n = Integer.parseInt(nq[0]);
            int q = Integer.parseInt(nq[1]);

            String[] inp = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = Integer.parseInt(inp[i]);

//            int[] res = new int[n];
            int oc = 0, ec = 0;
            for (int i=0; i<n; i++) {
//                res[i] = setBits(a[i]);
                int r = setBits(a[i]);
                if (r == 0) ec++;
                else oc++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<q; i++) {
                int p = Integer.parseInt(br.readLine());
                int setp = setBits(p);

                int re = 0, ro = 0;
                if (setp == 0) {
                    re = ec;
                    ro = oc;
                } else {
                    re = oc;
                    ro = ec;
                }
                sb.append(re +" " + ro + "\n");
            }

            System.out.print(sb);
        }
    }

    private static int setBits(int num) {
        int res = 0;
        while (num > 0) {
            res += num & 1;
            num >>= 1;
        }
        return (res % 2 == 0) ? 0 : 1;
    }
}
