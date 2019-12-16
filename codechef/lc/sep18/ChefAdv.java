package lc.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAdv {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n, m, x, y;
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            x = Integer.parseInt(str[2]);
            y = Integer.parseInt(str[3]);

            String res = check(n, m, x, y) ? "Chefirnemo" : "Pofik";
            System.out.println(res);
        }
    }

    private static boolean check(int n, int m, int x, int y) {
        if(n==1) {
            // check for if m is achievable
            if ((m-1)%y == 0)
                return true;
            else
                return false;
        } else if (m == 1) {
            // check for if n is achievable
            if ((n-1)%x == 0)
                return true;
            else
                return false;
        } else { // here both n and m are greater than 1
            if (((n - 1) % x == 0) && ((m - 1) % y == 0)) { // without sharechat
                return true;
            } else if (((n - 2) % x == 0) && ((m - 2) % y == 0)) { // with sharechat install
                return true;
            } else
                return false;
        }
    }
}
