package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Cards {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            String[] res = new String[c];
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> index = new HashMap<>();

            for (int i =0; i<c; i++) {
                String s = br.readLine();
                res[i] = s;

                int count = map.getOrDefault(s,0);
                if (count == 0) {
                    map.put(s, 1);
                } else {
                    map.put(s, count + 1);
                }
            }

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() > 1) {

                }
            }

        }
    }
}
