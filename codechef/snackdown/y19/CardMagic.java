package snackdown.y19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardMagic {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }

            int dips = 0, mark = -1;
            for (int i = 1; i < n; i++) {
                if (a[i] < a[i-1]) {
                    dips++;
                }
                if (dips > 0)
                    mark = a[i];
            }

            if (dips > 1) {
                System.out.println("NO");
            } else {
                if (mark == -1)
                    System.out.println("YES");
                else {
                    if (a[0] >= mark)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
            }

        }
    }
}
