package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CNote {
    static int readInt(String inp) {
        return Integer.parseInt(inp);
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            String[] inp = br.readLine().split(" ");
            int x = readInt(inp[0]);
            int y = readInt(inp[1]);
            int k = readInt(inp[2]);
            int n = readInt(inp[3]);

            int preq = x - y;
            boolean flag = false;
            for (int i=0; i<n; i++) {
                String[] b = br.readLine().split(" ");
                int p = readInt(b[0]);
                int cost = readInt(b[1]);
                if (!flag && p >= preq && cost <= k) {
                    flag = true;
                }
            }

            String res = flag ? "LuckyChef" : "UnluckyChef";
            sb.append(res + "\n");
        }
        System.out.println(sb);
    }

}
