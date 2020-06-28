package r646;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nx = br.readLine().split(" ");
            int n = Integer.parseInt(nx[0]);
            int x = Integer.parseInt(nx[1]);

            String[] as = br.readLine().split(" ");
            int o = 0, e = 0;
            for (int i=0; i<n; i++) {
                if (Integer.parseInt(as[i]) % 2 == 0) e++;
                else o++;
            }

            if (o == 0) {
                System.out.println("No");
            } else {
                if (x % 2 == 1) {
                    if (x <= o) System.out.println("Yes");
                    else if (o < x && o % 2 == 1) System.out.println("Yes");
                    else if (o < x && o % 2 == 0 && x - o + 1 <= e) System.out.println("Yes");
                    else System.out.println("No");
                } else {
                    if (x <= o && e > 0) System.out.println("Yes");
                    else if (o < x && o % 2 == 1) System.out.println("Yes");
                    else if (o < x && x - o + 1 <= e) System.out.println("Yes");
                    else System.out.println("No");
                }
            }

        }

    }
}
