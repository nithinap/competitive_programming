package r619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeStrings {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();

            boolean res = solve(a, b, c);
            String out = res ? "YES" : "NO";
            System.out.println(out);
        }
    }

    private static boolean solve(String a, String b, String c) {
        boolean res = true;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
              if (!(a.charAt(i) == c.charAt(i) || b.charAt(i) == c.charAt(i))) {
                  res = false;
                  break;
              }
            } else {
                if (a.charAt(i) == b.charAt(i) && a.charAt(i) != c.charAt(i)) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

}
