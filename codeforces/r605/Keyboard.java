package codeforces.r605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Keyboard {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        String w = br.readLine();

        String[] remove = br.readLine().split(" ");
        Set<Character> set = new HashSet<>();

        for (int i = 0; i<remove.length; i++) {
            set.add(remove[i].charAt(0));
        }

//        System.out.println(set);
        long len=0;
        int i = 0;

        long c = 0;
        while (i < w.length()){
            if (set.contains(w.charAt(i))) {
                c++;
            } else {
//                System.out.println("len ==" + len + "c = "+ c);
                len += (c * (c+1))/2;
                c = 0;
            }
            i++;
        }

        if (c > 0) len += (c * (c+1))/2;
        //long ans = (len%2 == 0) ? (len/2 * len)  : ((len+1)/2*len);
        System.out.println(len);
    }
}
