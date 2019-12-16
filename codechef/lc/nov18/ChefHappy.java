package lc.nov18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChefHappy {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n;
            n = Integer.parseInt(br.readLine());
            String[] num = br.readLine().split(" ");
            Set<Integer> val = new HashSet<>();
            Map<Integer, Set<Integer>> m = new HashMap<>();
            for(int i=0; i<n; i++) {
                int a = Integer.parseInt(num[i]);
                val.add(a);

                if (m.containsKey(a)) {
                    Set<Integer> s = m.get(a);
                    s.add(i);
                    m.put(a, s);
                } else {
                    Set<Integer> s = new HashSet<>();
                    s.add(i);
                    m.put(a, s);
                }
            }

//            System.out.println(m);
            boolean done = false;
            for (Map.Entry<Integer, Set<Integer>> e : m.entrySet()) {
                done = false;
                if (e.getValue().size() > 1) {
                    // check atleast 2 indexes are present in original array and have distinct values
                    Set<Integer> subset = new HashSet<Integer>();
                    Set<Integer> s = e.getValue();
                    done = false;
                    for (Integer elem : s) {
                        // elem+1 present in array or not
                        if (val.contains(elem+1)) {
                            subset.add(elem);
                            if(subset.size() > 1) {
                                done = true;
                                break;
                            }
                        }
                    }
                }
                if (done)
                    break;
            }
            String ans = done ? "Truly Happy" : "Poor Chef";
            System.out.println(ans);
        }
    }
}
