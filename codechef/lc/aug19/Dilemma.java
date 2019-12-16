package lc.aug19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dilemma {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String s = br.readLine();
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            if (count%2 == 0) System.out.println("LOSE");
            else System.out.println("WIN");
        }
    }
}
