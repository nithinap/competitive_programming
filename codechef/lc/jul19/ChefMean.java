package lc.jul19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefMean {

    public static void main(String[] args) throws IOException {
        int t;
        String IMPOSSIBLE = "Impossible";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            double sum = 0;
            Long[] set = new Long[n];
            for (int i=0; i<n; i++) {
                long a = Long.parseLong(arr[i]);
                set[i] = a;
                sum += a;
            }

            sum /= n;

//            System.out.println("mean: " + sum);
            if (sum % 1 == 0) {
//                System.out.println("no decimal");
                long r = (long) sum;
                int pos = lSearch(set, r);
                if (pos != -1) {
//                    System.out.println(pos);
                    sb.append(pos);
                } else {
//                    System.out.println(IMPOSSIBLE);
                    sb.append(IMPOSSIBLE);
                }
            } else {
//                System.out.println(IMPOSSIBLE);
                sb.append(IMPOSSIBLE);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int lSearch(Long[] set, long r) {
        for (int i=0; i<set.length; i++) {
            if (set[i] == r)
                return i+1;
        }
        return -1;
    }
}
