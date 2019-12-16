package codejam.OneA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}



public class AlienRhyme {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        for (int x=1; x<=t; x++) {
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            for (int i=0; i<n; i++) {
                str[i] = br.readLine();
            }

            Map<String, Set<Pair>> map = new TreeMap<>();

            for (int i=0; i<n-1; i++) {
                for (int j=i+1; j<n; j++) {
                    String a = str[i];
                    String b = str[j];
                    String ls = longestSuffix(a, b);
                    if (ls != null) {
                        Pair p = new Pair(i, j);
                        if (map.containsKey(ls)) {
                            Set<Pair> s = map.get(ls);
                            s.add(p);
                            map.put(ls, s);
                        } else {
                            Set<Pair> s = new HashSet<>();
                            s.add(p);
                            map.put(ls, s);
                        }
                    }
                }
            }

            long res  = 0;
            Set<Character> charSet = new HashSet<>();
            Set<Integer> strSet = new HashSet<>();
            for (int i=0; i<n; i++) {
                strSet.add(i);
            }

            TreeMap<Integer, Set<String>> lenMap = new TreeMap<Integer, Set<String>>(Collections.reverseOrder());
            for (Map.Entry<String, Set<Pair>> e: map.entrySet()) {
                int psize = e.getValue().size();
                if (lenMap.containsKey(psize)) {
                    Set<String> s = lenMap.get(psize);
                    s.add(e.getKey());
                    lenMap.put(psize, s);
                } else {
                    Set<String> s = new HashSet<>();
                    s.add(e.getKey());
                    lenMap.put(psize, s);
                }
            }

            for (Map.Entry<Integer, Set<String>> e: lenMap.entrySet()) {
                for (String suf :e.getValue()) {
                    String key = suf;
                    Set<Pair> pairSet = map.get(key);
//                    System.out.println("Map key > " + key);
//                    System.out.println("Map val >" + pairSet);
                    for (int i = 0; i < key.length(); i++) {
                        if (!charSet.contains(key.charAt(i))) {
                            charSet.add(key.charAt(i));
                            for (Pair p : pairSet) {
                                if (strSet.contains(p.a) && strSet.contains(p.b)) {
                                    strSet.remove(p.a);
                                    strSet.remove(p.b);
                                    res++;
                                    break;
//                                    System.out.println(p.a + "," + p.b);
                                }
                            }
                        }
                    }
                }
            }


            System.out.println("Case #"+x+": " + res*2);
        }
    }

    private static String longestSuffix(String a, String b) {
        String s1, s2;
        if (a.length() > b.length()) {
            s1 = a;
            s2 = b;
        } else {
            s1 = b;
            s2 = a;
        }

        int len = 0;
        for (int i=s1.length()-1, j=s2.length()-1; i>=s1.length()-s2.length(); i--, j--) {
            if (s1.charAt(i) == s2.charAt(j)) len++;
            else
                break;
        }
        String suff = s1.substring(s1.length()-len, s1.length());
        return suff;
    }
}
