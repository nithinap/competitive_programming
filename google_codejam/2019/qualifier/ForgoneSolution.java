package codejam.qualifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForgoneSolution {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int x=1; x<=t; x++) {
            String num = br.readLine();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i=0; i<num.length(); i++) {
                if (num.charAt(i) == '4') {
                    a.append(3);
                    b.append(1);
                } else {
                    a.append(num.charAt(i));
                    b.append(0);
                }
            }
//            System.out.println(a + " " + b);
            //a.toString();
            StringBuilder c = new StringBuilder();
            int i = 0;
            while (b.charAt(i) == '0') {
                i++;
            }
            String B = b.substring(i, b.length());
            String A = a.toString();
            System.out.println("Case #" + x + ": " + A + " " + B);
        }
    }
}
