package lc.oct19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxStarValue {

    public static Set<Integer> getDivisor(int num) {
        Set<Integer> div = new HashSet<>();
        for (int i=1; i<=Math.sqrt(num); i++) {
            if (num%i == 0) {
                div.add(i);
                div.add(num/i);
            }
        }
        return div;
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
//        long st = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            Map<Integer, Integer> ans = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            String[] as = br.readLine().split(" ");
            int res = 0;
            for (int i =0; i<n; i++) {
                int num = Integer.parseInt(as[i]);
                if (ans.containsKey(num) && res < ans.get(num))  {
                    res = ans.get(num);
//                    System.out.println("====> num " + num + "; res: "+ res);
                }

                Set<Integer> s = getDivisor(num);
//                System.out.println("for "+ num + "=> " + s);
                for(int fact: s) {
                    if (ans.containsKey(fact)) {
                        int val = ans.get(fact);
                        ans.put(fact, val+1);
                    } else {
                        ans.put(fact, 1);
                    }
                }
            }

            sb.append(res + "\n");

        }
        System.out.print(sb);
//        long end = System.currentTimeMillis();
//        System.out.println(end-st);
    }
}
