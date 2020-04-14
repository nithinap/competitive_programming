package r631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n, x;
            String[] nx = br.readLine().split(" ");
            n = Integer.parseInt(nx[0]);
            x = Integer.parseInt(nx[1]);
            String[] sr = br.readLine().split(" ");

            boolean[] arr = new boolean[105];
            for (int i=0; i<n; i++) {
                int val = Integer.parseInt(sr[i]);
                arr[val] = true;
            }

            int i = 1;
            boolean flag= false;
            for (; i<arr.length; i++) {
                if (!arr[i]) {
                    if (x == 0) {
                        flag = true; break;
                    }
                    else --x;
                }
            }

            System.out.println(i-1 + x);
        }
    }
}
