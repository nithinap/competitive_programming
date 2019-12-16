//package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoZ {

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            if (a == b) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
