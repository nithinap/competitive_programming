package lc.oct18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefServe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        int p1, p2, k;

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            p1 = Integer.parseInt(s[0]);
            p2 = Integer.parseInt(s[1]);
            k = Integer.parseInt(s[2]);
            long sum = p1+p2;
            long turns = sum/k;
            if(turns%2 == 0) {
                // chef's turn
                System.out.println("CHEF");
            } else
                System.out.println("COOK");
        }
    }
}
