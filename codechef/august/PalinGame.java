package lc.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalinGame {

	private static int solveGame(String s, String t) {
		Set<Character> A = new HashSet<Character>();
		Set<Character> B = new HashSet<Character>();
		Map<Character, Integer> Amap = new HashMap<Character, Integer>();
		// Map<Character, Integer> Bmap = new HashMap<Character, Integer>();

		// System.out.println("for strings ==> "+s+", "+t);

		for (int i = 0; i < s.length(); i++) {
			A.add(s.charAt(i));
			B.add(t.charAt(i));

			Amap.put(s.charAt(i), (Amap.get(s.charAt(i)) != null) ? Amap.get(s.charAt(i)) + 1 : 1);
			// Bmap.put(t.charAt(i), (Bmap.get(t.charAt(i)) != null) ? Bmap.get(t.charAt(i)) + 1 : 1);

		}

		Set<Character> C = new HashSet<Character>(A);
		C.removeAll(B);
		// System.out.println("size A :"+A.size());
		
		Set<Character> D = new HashSet<Character>(B);
		D.removeAll(A);
		if (D.size() == 0 && C.size() > 0) { // A super-set of B
			return 0;
		}

		if (C.size() > 0) {
			// System.out.println("Size of A after (A-B): " + C.size());

			for (Character ch : C) {
				// System.out.println("Amap["+ch+"] -> "+Amap.get(ch));
				if (Amap.get(ch) >= 2) {
					return 0;
				}
			}
		}

		return 1;
	}

	public static void main(String[] args) throws IOException {
		int T;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		String s, t;

		while (T-- > 0) {
			s = br.readLine();
			t = br.readLine();

			String res = (solveGame(s, t) == 0) ? "A" : "B";
			System.out.println(res);
		}

	}
}
