package google.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AllYourBase {
	public static void main(String[] args) throws IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int k = 1; k <= t; k++) {
			String str;
			str = br.readLine();

			Map<Character, Integer> map = new HashMap<Character, Integer>();
			char[] arr = str.toCharArray();
			map.put(arr[0], 1);
			int val = 0;
			
			for (int i = 1; i < arr.length; i++) {
				if (!map.containsKey(arr[i])) {
					map.put(arr[i], val++);
					if (val == 1)
						val++;
				}
			}

			// compute the decimal notation
			long res = 0;
			int base = (val == 0) ? 2 : val;
			long pow = 1;

			for (int i = arr.length - 1; i >= 0; i--) {
				res += map.get(arr[i]) * pow;
				pow *= base;
			}

			System.out.println("Case #" + k + ": " + res);
		}
	}
}
