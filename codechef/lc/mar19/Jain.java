package lc.mar19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Jain {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] d = new String[n];
            for (int i = 0; i < n; i++) {
                d[i] = br.readLine();
            }
            Set<Character>[] s = new Set[n];
            for (int i = 0; i < n; i++) {
                s[i] = getCharset(d[i]);
            }

            long tot = 0, x = 0;

//            Arrays.sort(s, new Comparator<Set<Character>>() {
//                @Override
//                public int compare(Set<Character> o1, Set<Character> o2) {
//                    return o2.size() - o1.size();
//                }
//            });

            Map<Integer, List<Set<Character>>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int size = s[i].size();
                if (map.containsKey(size)) {
                    List<Set<Character>> list = map.get(size);
                    list.add(s[i]);
                } else {
                    List<Set<Character>> l = new LinkedList<>();
                    l.add(s[i]);
                    map.put(size, l);
                }
            }

            for (int i = 1; i < 3; i++) {
                if (map.containsKey(i)) {
                    for (Set<Character> set : map.get(i)) {
                        if (map.containsKey(5 - i)) {
                            List<Set<Character>> comp = map.get(5 - i);
                            for (Set<Character> other : comp) {
                                Set<Character> mset = new HashSet<>();
                                mset.addAll(other);
                                mset.addAll(set);
                                if (mset.size() == 5) {
                                    tot++;
//                                    System.out.println("add d"+i + " and d"+(5-i));
                                }
                            }
                        }
                    }
                }
            }

            if (map.containsKey(5)) {
                x = map.get(5).size();
                tot += (x % 2 == 0) ? (x / 2) * (x - 1) : (x - 1) / 2 * x;
                tot += (x * (n-x));
            }
            System.out.println(tot);
        }
    }

    private static Set<Character> getCharset(String dish) {
        Set<Character> chSet = new HashSet<>();
        for (int i = 0; i < dish.length(); i++) {
            Character ch = dish.charAt(i);
            chSet.add(ch);
            if (chSet.size() == 5) break;
        }
        return chSet;
    }
}
