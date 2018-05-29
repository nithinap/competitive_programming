package lc.feb18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefPatent {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t, n, m, x, k;
		String s;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			x = Integer.parseInt(str[2]);
			k = Integer.parseInt(str[3]);

			s = br.readLine();
			int even = 0, odd = 0;
			for (String ch : s.split("")) {
				if (ch.equals("E"))
					even++;
				else
					odd++;
			}
			
			//System.out.println(even+" "+odd);
			
			for (int i = 1; i <= m; i++) {
				if (i % 2 == 0 && even > 0) {
					int minex = Math.min(x, even);
					n -= minex;
					k -= minex;
					even = (minex == even) ? 0 : even - x;
				} else if (i%2 == 1 && odd > 0) {
					int mineo = Math.min(x, odd);
					n -= mineo;
					k -= mineo;
					odd = (mineo == odd) ? 0 : odd - x;
				}
				if (n <= 0 || k < 0)
					break;
			}

			if (n <= 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}
}
