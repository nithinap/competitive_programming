package lc.aug18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpellBob {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s1 = br.readLine();
			String s2 = br.readLine();

			String res = isBobPossible(s1, s2) ? "yes" : "no";
			System.out.println(res);
		}
	}

	private static boolean isBobPossible(String s1, String s2) {
			int[] cb = new int[3];
			int[] co = new int[3];
			for (int i=0; i<3; i++) {
				if (s1.charAt(i) == 'b') 
					cb[i]++;
				else if (s1.charAt(i) == 'o')
					co[i]++;
				if (s2.charAt(i) == 'b')
					cb[i]++;
				else if (s2.charAt(i) == 'o')
					co[i]++;
			}
			
			int po = 0, indo = -1;
			for (int i=0; i<3; i++) {
				if (co[i] > 0) {
					po++;
					indo = i;
				}
			}
			
			if (po == 1) { // only one 'o'
				int bs = 0;
				for (int i=0; i<3; i++) {
					if (i != indo && cb[i] > 0) {
						bs++;
					}
				}
				if (bs == 2)
					return true;
				else 
					return false;
			} else { // po 2 or 3
//				System.out.println("po: "+po);
				if (po == 2) {
					int bs = 0; boolean hasB = false;
					// remaining one position should have a 'b'
					for (int i=0; i<3; i++) {
						if (co[i] == 0 && cb[i] > 0) {
							bs++;
						} else if (co[i] > 0 && cb[i] > 0) {
							hasB = true;
						}
					}
					if (hasB && bs > 0)
						return true;
				} else if (po == 3) {
					// 2 positions must have 'b'
					int bs = 0;
					for (int i=0; i<3; i++) {
						if (cb[i] > 0) {
							bs++;
						}
					}
					if (bs > 1)
						return true;
				}
			}
			return false;
		
	}

}
