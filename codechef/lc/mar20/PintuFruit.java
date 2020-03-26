package lc.mar20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PintuFruit {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            Map<Integer, Integer> map = new HashMap<>();

            String[] fs = br.readLine().split(" ");
            String[] prices = br.readLine().split(" ");

            for (int i=0; i<n; i++) {
                int fruit = Integer.parseInt(fs[i]);
                int price = Integer.parseInt(prices[i]);
                map.put(fruit, map.getOrDefault(fruit, 0) + price);
            }

            int minPrice = 99999999;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                minPrice = Math.min(e.getValue(), minPrice);
            }

//            System.out.println(map);
            if (minPrice != 99999999) System.out.println(minPrice);
            else System.out.println(0);
        }
    }
}
