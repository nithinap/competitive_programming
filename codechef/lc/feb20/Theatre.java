package lc.feb20;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Theatre {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        long tot = 0;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] d = new int[4][4];

            for (int i=0; i<n; i++) {
                String[] in = br.readLine().split(" ");
                int row = in[0].charAt(0) - 'A';
                int col = Integer.parseInt(in[1])/3 - 1;
                d[row][col]++;
            }

            /*
            StringBuilder p = new StringBuilder();
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    p.append(d[i][j] + " ");
                }
                p.append("\n");
            }
            System.out.println(p);*/

            long max = Long.MIN_VALUE;
            int[] cost = {25, 50, 75, 100};
            for (int c1=0; c1<4; c1++) {
                int a = d[c1][0];
                for (int c2=0; c2<4; c2++) {
                    if (c2 != c1) {
                        int b = d[c2][1];
                        for (int c3 = 0; c3 < 4; c3++) {
                            if (c3 != c2 && c3 != c1) {
                                int c = d[c3][2];
                                for (int c4 = 0; c4 < 4; c4++) {
                                    if (c4 != c3 && c4 != c2 && c4 != c1) {
                                        int[] tmp = new int[4];
                                        long sum = 0;
                                        tmp[0] = a; tmp[1] = b; tmp[2] = c; tmp[3] = d[c4][3];
                                        Arrays.sort(tmp);
                                        for (int ind = 3; ind >= 0; ind--)
                                            sum += (tmp[ind] == 0) ? -100 : (tmp[ind] * cost[ind]);

                                        // System.out.println(c1 + " " + c2 + " " +c3 + " " +c4 + " ==>  " + sum);
                                        max = Math.max(max, sum);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(max);
            tot += max;
        }
        System.out.println(tot);
    }
}
