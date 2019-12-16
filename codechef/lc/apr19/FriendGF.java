package lc.apr19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendGF {
    static long countStr(long n) {
        long tot = 0;
        if (n%2 == 0) tot = n/2 * (n+1);
        else tot = (n+1)/2 * n;
        return tot;
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] sa = br.readLine().split(" ");
            long res = countStr((long)n);
            String s = sa[0];
            char a = sa[1].charAt(0);

            int len = 0;
            for (int i=0; i<n; i++) {
                if(s.charAt(i) == a) {
                    if (len > 0) {
                        res -= countStr(len);
                        len = 0;
                    }

                } else
                    len++;
            }
            if (len > 0) {
                res -= countStr(len);
            }
            System.out.println(res);
        }
    }
}
