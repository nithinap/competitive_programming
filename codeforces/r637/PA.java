package r637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            int c = Integer.parseInt(s[3]);
            int d = Integer.parseInt(s[4]);


            int ming = a - b, maxg = a + b;
            int minw = c - d, maxw = c + d;
            int mint = ming * n, maxt = maxg * n;

            String res = ((mint >= minw && mint <= maxw) || (maxt >= minw && maxt <= maxw) || (mint <= minw && maxt >= maxw)) ? "Yes" : "No";
            System.out.println(res);
        }
    }
}
