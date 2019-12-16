package lc.aug19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GudduXOR {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] astr = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(astr[i]);
            }

            int[] pxor = new int[n];
            pxor[0] = a[0];
            for (int i = 1; i < n; i++) {
                pxor[i] = pxor[i - 1] ^ a[i];
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(-1);
            map.put(0, tmp);

            for (int i = 0; i < n; i++) {
                if (map.containsKey(pxor[i])) {
                    List<Integer> list = map.get(pxor[i]);
                    list.add(i);
                    map.put(pxor[i], list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(pxor[i], list);
                }
            }

//            System.out.println(map);
            long sum = 0;
            for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
                List<Integer> list = e.getValue();
                    if (list.size() > 1) {
                        int len = list.size();
//                        System.out.println("len: " + len + "| sum: "+sum);
                        for (int i = 1; i < len; i++) {
                            int diff = list.get(i) - list.get(i - 1);
//                            System.out.println("-- " + diff);
                            sum += (diff * (len - i) * i);
//                            System.out.println(">>> " + sum);
                        }
                        long extra = 0;
                        if (len % 2 == 0)
                            extra = len / 2 * (len - 1);
                        else
                            extra = (len - 1) / 2 * len;

                        sum -= extra;
//                        System.out.println("for " + list + ":" + sum);
                } /*else {
                    int len = list.size();
                    sum += list.get(0);
                    for (int i = 1; i < len; i++)  {
                        sum += list.get(i);
                        sum += list.get(i)- list.get(i-1) - 1;
                    }
                }*/
            }
            System.out.println(sum);
        }
    }
}
