package snackdown.y19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chfar {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int k, n;
            String[] kn = br.readLine().split(" ");
            n = Integer.parseInt(kn[0]);
            k = Integer.parseInt(kn[1]);
            String[] as = br.readLine().split(" ");
            int val = n;
            for (int i=0; i<n; i++) {
                if (as[i].equals("1")) {
                    val--;
                }
            }
//            System.out.println(val);
            if (val <= k) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }
}
