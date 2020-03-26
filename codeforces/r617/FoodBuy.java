package r617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoodBuy {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long res = solve(n);
            System.out.println(res);

        }
    }

    private static long solve(int n) {
        if (n < 10) return n;
        int rem = 0;
        long res = 0;
        while (n > 9) {
            rem = (n%10);
            n /= 10;
            res += n * 10;
            n += rem;
        }

        res += n;
        return res;
    }
}
