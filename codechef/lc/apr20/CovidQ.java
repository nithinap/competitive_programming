package lc.apr20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CovidQ {
    public static void main(String[] args) throws IOException {
        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            String res = solve(n, s);
            System.out.println(res);
        }

    }

    private static String solve(int n, String[] s) {
        int pi = -1;

        for (int i=0; i<n; i++) {
            if (s[i].equals("1")) {
                if (pi == -1) pi = i;
                else {
                    if(i - pi < 6) return "NO";
                    pi = i;
                }
            }
        }

        return "YES";
    }
}
