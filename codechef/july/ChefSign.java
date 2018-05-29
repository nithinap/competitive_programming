package lc.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefSign {

	private static void computeP(String str) {
		int max_less = 0;
		int cur_less = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '<') {
				cur_less++;
				if (max_less < cur_less)
					max_less = cur_less;
			} else if (ch == '=') {
				continue;
			} else
				cur_less = 0;

		}

		int cur_grt = 0, max_grt = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '>') {
				cur_grt++;
				if (max_grt < cur_grt)
					max_grt = cur_grt;
			} else if (ch == '=') {
				continue;
			} else
				cur_grt = 0;
		}

		int result = (max_grt > max_less) ? max_grt + 1 : max_less + 1;

		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();

			computeP(str);
		}
	}

}
