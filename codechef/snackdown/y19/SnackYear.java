package snackdown.y19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SnackYear {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        //2010, 2015, 2016, 2017 and 2019.
        String[] years = {"2010", "2015", "2016", "2017", "2019"};
        Set<Integer> s = new HashSet(Arrays.asList(years));
        while(t-- > 0) {
            String y = br.readLine();
            String res = s.contains(y) ? "HOSTED" : "NOT HOSTED";
            System.out.println(res);
        }
    }
}
