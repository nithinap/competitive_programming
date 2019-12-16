package codeforces.r608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tent {
    public static void main(String[] args) throws IOException {
        String[] s ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int sx = Integer.parseInt(s[1]);
        int sy = Integer.parseInt(s[2]);

        int gx = 0, lx = 0, gy = 0, ly = 0, ex = 0, ey = 0;
        for (int i=0; i<n; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            if (x > sx) gx++;
            else if (x < sx) lx++;
//            else ex++;

            if (y > sy) gy++;
            else if (y < sy) ly++;
//            else ey++;
        }

//        System.out.println(gx + " " + lx);
//        System.out.println(gy + " " + ly);

        int[] val = new int[4];
        val[0] = gy;
        val[1] = ly;
        val[2] = lx;
        val[3] = gx;

        Arrays.sort(val);

        if (val[3] == gy) System.out.println(val[3] + "\n" + sx + " " + (sy+1));
        else if (val[3] == ly) System.out.println(val[3] + "\n" + sx + " " + (sy-1));
        else if(val[3] == gx) System.out.println(val[3] + "\n" + (sx+1) + " " + sy);
        else System.out.println(val[3] + "\n" + (sx-1) + " " + sy);
    }
}
