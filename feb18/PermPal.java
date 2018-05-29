package lc.feb18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PermPal {

	private static void tester(String s, int[] perm) {
		char[] pal = new char[s.length()];
		for (int i = 1; i <= s.length(); i++) {
			// System.out.println("i: "+ i);
			pal[perm[i] - 1] = s.charAt(i - 1);
		}

		System.out.println(new String(pal));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		String s;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			s = br.readLine();
			Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
			int[] perm = new int[s.length() + 1];

			for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i))) {
					List<Integer> list = map.get(s.charAt(i));
					list.add(i + 1);
					map.put(s.charAt(i), list);
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(i + 1);
					map.put(s.charAt(i), list);
				}
			}

			int count_odds = 0;
			int odd_len = -1;
			for (Entry<Character, List<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() % 2 == 1) {
					count_odds++;
					odd_len = entry.getValue().size();
				}
			}

			if (count_odds > 1) {
				// not possible
				System.out.println("-1");
			} else {
				int start_ind = 1, end_ind = s.length();
				int mid_ind = (count_odds == 1) ? ((end_ind - odd_len) / 2) + 1 : -1;
				for (Entry<Character, List<Integer>> entry : map.entrySet()) {
					List<Integer> list = entry.getValue();
					if (list.size() % 2 == 0) {
						for (int i = 0; i < list.size(); i += 2) {
							perm[start_ind] = list.get(i);
							perm[end_ind] = list.get(i + 1);
							start_ind++;
							end_ind--;
						}
					} else {
						// with middle fills
						for (int i = 0; i < list.size(); i++) {
							if (mid_ind != -1)
								perm[mid_ind++] = list.get(i);
						}
					}
				}

				for (int i = 1; i < s.length(); i++) {
					System.out.print(perm[i] + " ");
				}

				System.out.println(perm[s.length()]);

				// tester(s, perm);
			}

		}
	}

}
