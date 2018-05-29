package lc.sept17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c;
		int[] dig = new int[10];
		t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			Arrays.fill(dig, 0);
			while((c = br.read()) != -1 && c > 47 && c < 58) {
				//System.out.println(c);
				dig[Character.getNumericValue(c)]++;
			}
			
			for (int i=0; i<10; i++) {
				System.out.print(dig[i]+" ");
			}
			br.read();
			System.out.println();
		}
	}
}
