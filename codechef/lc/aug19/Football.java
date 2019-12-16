package lc.aug19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Football {
    public static void main(String[] args) throws IOException {
        int t, n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] as = br.readLine().split(" ");
            String[] bs = br.readLine().split(" ");

            int max = 0;
            for (int i=0; i<n; i++) {
                int score = Integer.parseInt(as[i])*20 - Integer.parseInt(bs[i])*10;
                if (score > max) max = score;
            }
            System.out.println(max);
        }
    }
}
