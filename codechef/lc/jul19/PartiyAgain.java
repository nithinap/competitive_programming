package lc.jul19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PartiyAgain {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            Set<Integer> set = new HashSet<>();
            long co = 0, ce = 0;
            int q = Integer.parseInt(br.readLine());

            for(int i=0; i<q; i++) {
                int x = Integer.parseInt(br.readLine());

                int prevSize = set.size();
                set.add(x);
                int newSize = set.size();
                if (newSize > prevSize) {
                    int bits = countSetBits(x);

                    Set<Integer> tmpSet = new HashSet<>();
                    for (Integer num: set) {
                        tmpSet.add(num ^ x);
                    }
                    set.addAll(tmpSet);

                    long newEven = 0, newOdd = 0;
                    if (bits%2 ==0) {
                        newEven = ce;
                        newOdd = co;
                        ce++;

                    } else {
                        newEven = co;
                        newOdd = ce;
                        co++;

                    }

                    ce += newEven;
                    co += newOdd;
                }
                sb.append(ce+" " +co+"\n");
//                System.out.println(ce+" " +co);
            }
        }
        System.out.println(sb);
    }

    private static int countSetBits(int x) {
        int count = 0;
        while (x > 0) {
            count += (x & 1);
            x = x >> 1;
        }
        return count;
    }
}
