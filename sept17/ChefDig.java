package lc.sept17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefDig {
	public static void main(String[] args) throws IOException {
		int t;
		int[] dig = new int[10];
		int c;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		

		while (t-- > 0) {
			Arrays.fill(dig, 0);

			while((c = br.read()) != -1 && c>47 && c <58) {
				dig[Character.getNumericValue(c)]++;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 65; i <= 90; i++) {
				int unit = i%10, tens=i/10;
				
				if (tens != unit) {
					if (dig[tens] > 0 && dig[unit] > 0) {
						// System.out.println(i);
						sb.append((char) i);
					}
				} else if (dig[tens] > 1) {
					// cases like 66, 77, 88
					sb.append((char) i);
				}
			}
			System.out.println(sb.toString());
			//br.read();
		}

	}
}