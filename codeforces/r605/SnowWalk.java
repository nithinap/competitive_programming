package codeforces.r605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SnowWalk {
    public static void main(String[] args) throws IOException {
        int q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            String p = br.readLine();
            int[] a = new int[4];

            for (int i =0; i<p.length(); i++) {
                if (p.charAt(i) == 'L') a[0]++;
                else if (p.charAt(i) == 'R') a[1]++;
                else if (p.charAt(i) == 'U') a[2]++;
                else if (p.charAt(i) == 'D') a[3]++;
            }

//            System.out.println("=======");
//            System.out.println(Arrays.toString(a));

            int ud = Math.min(a[2], a[3]);
            int lr = Math.min(a[0], a[1]);

            int udd = 0;
            if(a[2] != 0 && a[3]!=0) {
                udd = ud * 2;
            }

            int lrd = 0;
            if (a[0] != 0 && a[1] != 0) {
                lrd = lr * 2;
            }

            long ans = 0;

            if (udd != 0 && lrd != 0) {
                ans = lrd + udd;
                sb.append(ans + "\n");
                for (int i =0; i<ud; i++) sb.append("U");
                for (int i=0; i<lr; i++) sb.append("R");
                for (int i =0; i<ud; i++) sb.append("D");
                for (int i=0; i<lr; i++) sb.append("L");

            } else if (udd != 0 && lrd == 0 ) {
                sb.append("2\nUD");
            } else if (lrd != 0 && udd == 0) {
                sb.append("2\nLR");
            } else
                sb.append("0");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
