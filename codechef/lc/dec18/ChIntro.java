package lc.dec18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChIntro {
    public static void main(String[] args) throws IOException {
        int n, r;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        r = Integer.parseInt(str[1]);
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            if (t < r) {
                sb.append("Bad boi\n");
            } else
                sb.append("Good boi\n");
        }
        System.out.println(sb.toString());
    }
}
