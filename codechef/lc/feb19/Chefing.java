package lc.feb19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Chefing {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] s = new String[n];
            for (int i=0; i<n; i++) {
                s[i] = br.readLine();
            }

            Map<Character, Set<Integer>> map = new HashMap<>();

            for (int i=0; i<n; i++) {
                String str = s[i];
                // create set of chars in str
                Set<Character> chSet = new HashSet<>();
                for (int j=0; j<str.length(); j++) {
                    Character ch = str.charAt(j);
                    chSet.add(ch);
                }

                for (Character ch: chSet) {
                    if (map.containsKey(ch)) {
                        Set<Integer> stringSet = map.get(ch);
                        stringSet.add(i);
                    } else {
                        Set<Integer> stringSet = new HashSet<>();
                        stringSet.add(i);
                        map.put(ch, stringSet);
                    }
                }
            }

            int res = 0;
            for (Map.Entry<Character, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == n) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
