
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PowerArrange {

    static char[] res;

    public static void main(String[] args) throws IOException {
        int t, f;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] st = br.readLine().split(" ");
        String[] st = in.nextLine().split(" ");
        if (st.length > 1) {
            t = Integer.parseInt(st[0]);
            f = Integer.parseInt(st[1]);
        } else {
            t = Integer.parseInt(st[0]);
            f = in.nextInt();
        }

        int perm = 119;

        while (t-- > 0) {
            char[] res =  new char[5];
            char[] pval = new char[perm*5 + 1];

            int[] v = new int[5];
            // get first char
            for (int i=1; i<perm*5; i+= 5) {
                System.out.println(i);
                char ans = in.nextLine().charAt(0); // br.readLine().charAt(0);
                System.out.println(ans-'A');
                v[ans - 'A']++;
            }
            res[0] = getMissing(v, 24);

            for (int i=0; i<5; i++) v[i] = 0;
            for (int i=1; i<perm*5; i+= 5) {
                System.out.println(i);
                char ans = in.next().charAt(0); //br.readLine().charAt(0);
                v[ans - 'A']++;
                pval[i] = ans;
            }

            Set<Integer> set = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int i = 1; i < perm * 5; i += 5) {
                if (pval[i] == res[0]) set.add(i + 1);
            }

            int left = 24;
            for (int k = 0; k<3; k++) {
                for (int i=0; i<5; i++) v[i] = 0;
                set.clear();
                set.addAll(set2);
                for (Integer pos: set) {
                    System.out.println(pos);
//                    char ans = br.readLine().charAt(0);
                    char ans = in.next().charAt(0);
                    v[ans - 'A']++;
                    pval[pos] = ans;
                }
                left = left/(4-k);
                res[k + 1] = getMissing(v, left);
                for (Integer pos: set) {
                    if (pval[pos] == res[k+1]) set2.add(pos+1);
                }
            }

            for (int i=0; i<5; i++) v[i] = 0;
            for (int i=0; i<5; i++) {
                v[res[i] - 'A']++;
            }
            for (int i=0; i<5; i++) {
                if(v[i] != 1) res[4] = (char)(i + 'A');
            }
            System.out.println(res);
        }

    }

    private static char getMissing(int[] v, int lim) {
        for (int i=0; i<v.length; i++) {
            if (v[i] > 0 && v[i] != lim) {
                return (char) (i + 'A');
            }
        }
        return '\0';
    }
}
