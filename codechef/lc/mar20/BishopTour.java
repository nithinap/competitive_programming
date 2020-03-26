package lc.mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BishopTour {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] rc = br.readLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);

            bishopTour(r, c);
        }
    }

    private static void bishopTour(int r, int c) {
        int mid = (r+c)/2;
        StringBuilder sb = new StringBuilder();
        sb.append("27\n");
        sb.append(mid + " " + mid+ "\n");
        sb.append("1 1\n");
        for (int i=2; i<5; i++) {
            sb.append(i + " " + i + "\n");
            sb.append("1 "+ (2*i - 1) + "\n");
            sb.append((2*i-1)+ " 1\n") ;
            sb.append(i + " " + i + "\n");
        }

        for (int i=5; i<8; i++) {
            sb.append(i + " " + i+ "\n");
            sb.append("8 "+ (2*i - 8)+ "\n");
            sb.append((2*i-8)+ " 8\n");
            sb.append(i+ " "+i + "\n");
        }

        sb.append("8 8\n");
        System.out.print(sb);
    }
}
