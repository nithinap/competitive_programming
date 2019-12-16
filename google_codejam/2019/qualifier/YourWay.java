package codejam.qualifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YourWay {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int x=1; x<=t; x++) {
            String n = br.readLine();
            String p = br.readLine();
            StringBuilder s = new StringBuilder();
            for (int i=0; i<p.length(); i++) {
                if (p.charAt(i) == 'E')
                    s.append("S");
                else
                    s.append("E");
            }
            System.out.println("Case #" + x + ": " + s);
        }
    }
}
