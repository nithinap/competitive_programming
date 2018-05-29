package lc.oct17;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxMex {
	public static void main(String[] args) {
		int t, n, k;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			Set<Integer> s = new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				s.add(sc.nextInt());
			}

			int max = Collections.max(s);
//			System.out.println("Max in set: " + max);

			int[] elem = new int[max + 1];
			Arrays.fill(elem, 0);
			for (Integer i : s) {
				elem[i] = 1;
			}


			int maxmex = -1;
			for (int i = 0; i < elem.length; i++) {
				if (elem[i] == 0) {
					//System.out.print("for i = "+i+" ;");
					if (k == 0) {
						maxmex = i;
						break;
						// System.out.println(">>===>> "+maxmex);
					} else if (k > 0) {
						--k;
					}
					//System.out.println("maxmex :"+maxmex+" ; k :"+k);
				}
			}
			if (maxmex == -1)
				maxmex = elem.length + k;
			System.out.println(maxmex);
		}
		sc.close();
	}
}
