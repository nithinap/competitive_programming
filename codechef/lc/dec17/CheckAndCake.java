package lc.dec17;

import java.util.Scanner;

public class CheckAndCake {
	public static void main(String[] args) {
		int t, n, m, mincost;
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		while (t-- > 0) {
			mincost = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			String[] str = new String[n];

			for (int i = 0; i < n; i++) {
				str[i] = sc.next();
				// mincost += (RGRcost < GRGcost) ? RGRcost : GRGcost;
			}

			int RGRtype1 = 0, GRGtype2 = 0;
			for (int i = 0; i < n; i += 2) {			
				for (int j = 0; j < m; j += 2) {
					if (str[i].charAt(j) == 'G') { // for RGRG..., odd places are R
						RGRtype1 += 3;
					} else { // for GRGR..., odd places are G
						GRGtype2 += 5;
					}
				}

				for (int j = 1; j < m; j += 2) {
					if (str[i].charAt(j) == 'R') { // for RGRG..., even places are G
						RGRtype1 += 5;
					} else { // for GRGR..., even places are R
						GRGtype2 += 3;
					}
				}
			}
			
			int RGRtype2 = 0, GRGtype1 = 0;
			for (int i = 1; i < n; i += 2) {			
				for (int j = 0; j < m; j += 2) {
					if (str[i].charAt(j) == 'G') { // for RGRG..., odd places are R
						RGRtype2 += 3;
					} else { // for GRGR..., odd places are G
						GRGtype1 += 5;
					}
				}

				for (int j = 1; j < m; j += 2) {
					if (str[i].charAt(j) == 'R') { // for RGRG..., even places are G
						RGRtype2 += 5;
					} else { // for GRGR..., even places are R
						GRGtype1 += 3;
					}
				}
			}	
		
			int type1 = (RGRtype1 + GRGtype1);
			int type2 = (RGRtype2 + GRGtype2);
			mincost =  (type1 < type2)? type1 : type2;
			
			System.out.println(mincost);
		}

		sc.close();
	}

}
