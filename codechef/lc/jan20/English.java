package lc.jan20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class English {
    static class Pair {
        int s, e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return s == pair.s &&
                    e == pair.e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }

        @Override
        public String toString() {
            return "P{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                String w = br.readLine();
                map.put(w, map.getOrDefault(w, 0)+1);
            }

            long ans = 0;
            Set<String> addBack = new HashSet<>();
            Set<String> toRemove = new HashSet<>();
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() > 1) {
                    long tmp = (long)Math.pow(e.getKey().length(), 2);
                    ans += tmp * (e.getValue()/2L);
                    if (e.getValue() % 2 == 0) toRemove.add(e.getKey()); //map.remove(e.getKey());
                    else addBack.add(e.getKey());//map.put(e.getKey(), 1); //list.add(e.getKey());
                }
            }
            for (String str : addBack) map.put(str, 1);
            for (String str: toRemove) map.remove(str);

            if (map.size() > 1) {
                //System.out.println("remains ");
                Map<Pair, Set<String>> common = new HashMap<>();
                for (Map.Entry<String, Integer> e : map.entrySet()) {
                    String k = e.getKey();
                    int st = k.charAt(0);
                    int end = k.charAt(k.length() - 1);
                    Pair p = new Pair(st, end);
                    if (common.containsKey(p)) {
                        Set<String> set = common.get(p);
                        set.add(k);
                        common.put(p, set);
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(k);
                        common.put(p, set);
                    }
                }

                //System.out.println(common);

                for (Map.Entry<Pair, Set<String>> e : common.entrySet()) {
                    Set<String> ev = e.getValue();
                    if (ev.size() > 1) {
                        String[] is = ev.toArray(new String[ev.size()]);
                        ans += computeScore(is);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static long computeScore(String[] str) {
        if (str.length < 2) return 0;
        long tot = 0;

        Map<Pair, Integer> pscore = new HashMap<>();

        for (int i=0; i<str.length-1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                Pair tp = new Pair(i, j);
                int score = getScore(str[i], str[j]);
                pscore.put(tp, score);
            }
        }

        Set<Map.Entry<Pair, Integer>> tset = pscore.entrySet();
        List<Map.Entry<Pair, Integer>> entries = new ArrayList<>(tset);
        Comparator<? super Map.Entry<Pair, Integer>> sortByScore = new Comparator<Map.Entry<Pair, Integer>>() {
            @Override
            public int compare(Map.Entry<Pair, Integer> o1, Map.Entry<Pair, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        Collections.sort(entries, sortByScore);
        //System.out.println("==> " + Arrays.toString(str));
        //System.out.println(entries);

        // greedy pick
        Set<Integer> matched = new HashSet<>();
        Iterator<Map.Entry<Pair, Integer>> it = entries.iterator();
        Pair f = it.next().getKey();
        long fscore = pscore.get(f);
        matched.add(f.s);
        matched.add(f.e);
        tot += fscore * fscore;

        while (it.hasNext()) {
            Pair temp = it.next().getKey();
            if (!matched.contains(temp.s) && !matched.contains(temp.e)) {
                matched.add(temp.s);
                matched.add(temp.e);
                long s = pscore.get(temp);
                tot += s * s;
            }
        }
        // found best match for i th string
        //System.out.println("for s1: " + str[i] + " => " + str[mj] + "; score="+max);

        return tot;
    }

    private static int getScore(String s1, String s2) {
        int ls1 = s1.length();
        int ls2 = s2.length();

        int len = Math.min(ls1, ls2);
        int score = 0;
        for (int i=0; i<len; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s1.charAt(ls1-1-i) == s2.charAt(ls2-1-i)) {
                score++;
            } else break;
        }
        return score;
    }
}
