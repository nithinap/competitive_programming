package lc.august;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Company {
	int offersal;
	int maxoffers;
	boolean hired;

	Company(int offersal, int maxoffers) {
		this.offersal = offersal;
		this.maxoffers = maxoffers;
		this.hired = false;
	}

	public int getMaxoffers() {
		return maxoffers;
	}

	public void setMaxoffers(int maxoffers) {
		this.maxoffers = maxoffers;
	}
}

public class GreedyCandidate {

	private static void solve(int[] minsal, Company[] comp, String[] qual, int n, int m) {
		// Arrays.sort(comp, (o1, o2) -> ((o1.offersal < o2.offersal)? 1: -1));
		long totsal = 0;
		int placed = 0;
		int zeroPlaced = 0;

		for (int i = 0; i < n; i++) {
			// System.out.println(comp[i].offersal +", "+comp[i].maxoffers);
			// assign company to the ith student
			// minsal[i] - min req salary
			Set<Integer> s = new HashSet<Integer>(); // qualified companies
			for (int j = 0; j < m; j++) {
				if (qual[i].charAt(j) == '1') {
					if (comp[j].offersal >= minsal[i] && comp[j].maxoffers > 0)
						s.add(j);
				}
			}

			if (s.size() > 0) {
				// find company(with max offer) to place among qualified
				int max_ind = s.iterator().next(); // initialize with one of the
													// indexes in set

				for (Integer ind : s) {

					if (comp[ind].offersal > comp[max_ind].offersal && comp[ind].maxoffers > 0) {
						max_ind = ind;
					}
				}

				// if (comp[max_ind].maxoffers > 0) {
				// assign max_ind th company to ith student
				comp[max_ind].maxoffers--;
				totsal += comp[max_ind].offersal;
				placed++;
				comp[max_ind].hired = true;

				//System.out.println("Candidate: " + (i + 1) + "; Company: " + (max_ind + 1) + "; Left offers:"
				//		+ comp[max_ind].maxoffers);

				// }
			}
		}

		for (int i = 0; i < m; i++) {
			if (!comp[i].hired)
				zeroPlaced++;
		}

		System.out.println(placed + " " + totsal + " " + zeroPlaced);
	}

	public static void main(String[] args) {
		int t, n, m;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();

			int[] minsal = new int[n];
			Company[] comp = new Company[m];
			String[] qual = new String[n];

			for (int i = 0; i < n; i++)
				minsal[i] = sc.nextInt();

			for (int i = 0; i < m; i++) {
				comp[i] = new Company(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < n; i++) {
				qual[i] = sc.next();
			}

			solve(minsal, comp, qual, n, m);
		}
		sc.close();
	}
}
