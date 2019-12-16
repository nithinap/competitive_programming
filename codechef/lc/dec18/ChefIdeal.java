package lc.dec18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefIdeal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1");
        int g = Integer.parseInt(br.readLine());
        if (g == 2) System.out.println("3");
        else System.out.println("2");
    }
}
