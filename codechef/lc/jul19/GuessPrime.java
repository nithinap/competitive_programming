package lc.jul19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class GuessPrime {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        while (t > 0) {
            System.out.println("1 31623");
            int m = Integer.parseInt(br.readLine());
            int num = 1000014129 - m;

            int lim = (int)Math.sqrt(num);
            ArrayList<Integer> primes = primefactorize(num, lim);
            //System.out.println(primes);

            int x = 0;
//            Pair p1 = new Pair(13, 1);
//            Pair p2 = new Pair(271, 1);
//
//            System.out.println(p1 == p2);
//            System.out.println(p1.hashCode() == p2.hashCode());

            map.clear();
            for (int i=3; i<=lim; i+=2) {

                for (Integer p: primes) {
                    int rem = (i * i)%p;

                    if (map.containsKey(rem)) break;
                    else {
                        map.put(rem, p);
                    }
                }

                if (map.keySet().size() == primes.size()) {
                    x = i;
                    break;
                }
                map.clear();
            }
            /*
            if (x == 0) {
                System.out.println("couldn't figure any x such that primes "+ primes + ", mod x is unique");
            }*/
            System.out.println("1 "+x);
            // System.out.println(map);

            // read mod value
            int newMod = Integer.parseInt(br.readLine());
            System.out.println("2 " + map.get(newMod));
            String verdict = br.readLine();
            if (!verdict.equals("Yes"))
                break;
            t--;
        }
    }

    private static ArrayList<Integer> primefactorize(int num, int lim) {
//        System.out.println(num + " " + lim);
        ArrayList<Integer> list = new ArrayList<>();
        boolean set = false;

        while (num % 2 == 0) {
            num >>= 1;
            set = true;
        }

        if (set) list.add(2);

        for (int i=3; i<=lim; i+=2) {
            set = false;
            while (num%i == 0) {
                num /= i;
                set = true;
            }
            if (set) list.add(i);
        }

        if (num > 2) list.add(num);

        return list;
    }
}
