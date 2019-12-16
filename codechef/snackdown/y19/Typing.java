package snackdown.y19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Typing {
    public static void main(String[] args) throws IOException {
        int t, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<String, Integer>();
            int cost = 0;
            while (n-- > 0) {
                String str = br.readLine();
                int hand = -1, cur = -1;
                if (map.containsKey(str)) {
                    cost += (map.get(str)/2);
                } else {
                    int tcost = 0;
                    for (int i=0; i<str.length(); i++) {
                        char c = str.charAt(i);
                        if (c == 'd' || c == 'f') {
                            // left
                            hand = 1;
                        } else { // for j and k
                            hand = 0;
                        }

                        if (cur == -1) {
                            tcost += 2;
                        } else if (cur == hand) {
                            tcost += 4;
                        } else {
                            tcost += 2;
                        }
                        cur = hand;
                    }
                    map.put(str, tcost);
                    cost += tcost;
                }
            }
            System.out.println(cost);
        }

    }
}
