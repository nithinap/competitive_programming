package lc.mar18;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MixColor {
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			Integer a;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				if (!map.containsKey(a))
					map.put(a, 1);
				else 
					map.put(a, map.get(a) + 1);
				
			}

			int count = 0;
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				count += entry.getValue() - 1;
			}

			System.out.println(count);
		}

		sc.close();
	}
}
