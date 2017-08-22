package lc.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Trainer {
	int d; // day of arrival
	int t; // intended number of lectures
	int s; // sadness

	Trainer(int di, int ti, int si) {
		d = di;
		t = ti;
		s = si;
	}
}

public class IpcTrain {

	public static void main(String[] args) {
		int t, n, d = 0;
		int di, ti, si;
		Map<Integer, List<Trainer>> tmap;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			d = sc.nextInt();
			tmap = new HashMap<Integer, List<Trainer>>();
			Trainer[] trainers = new Trainer[n];
			for (int i = 0; i < n; i++) {
				di = sc.nextInt();
				ti = sc.nextInt();
				si = sc.nextInt();
				trainers[i] = new Trainer(di, ti, si);
			}

			Arrays.sort(trainers, new Comparator<Trainer>() {
				@Override
				public int compare(Trainer o1, Trainer o2) {
					if (o1.d < o2.d)
						return -1;
					else if (o1.d == o2.d) {
						if (o1.s > o2.s)
							return -1;
						else
							return 1;
					}
					return 0;
				}
			});

			for (int i = 0; i < n; i++) {
				if (tmap.get(trainers[i].d) == null) {
					List<Trainer> tlist = new ArrayList<Trainer>();
					tlist.add(trainers[i]);
					tmap.put(trainers[i].d, tlist);
				} else {
					List<Trainer> tlist = tmap.get(trainers[i].d);
					tlist.add(trainers[i]);
					tmap.put(trainers[i].d, tlist);
				}
			}

/*			for (Entry<Integer, List<Trainer>> e : tmap.entrySet()) {
				System.out.print("Day " + e.getKey() + " -> ");
				for (Trainer tr : e.getValue()) {
					System.out.print(tr.s + ", ");
				}
				System.out.println();
			}*/

			for (int day = 1; day <= d; day++) {
				int maxKey = -1;
				int sadness = -999;

				for (int key = 1; key <= day; key++) {
					//System.out.println("key :" + key);
					if (tmap.get(key) != null) {
						int tmp = tmap.get(key).get(0).s;
						if (tmp > sadness) {
							maxKey = key;
							sadness = tmp;
						}
					}
				}

				// assign the trainer at maxKey -> List[0] the day and
				// decrease his demand
				if (maxKey > 0) {
					List<Trainer> tlist = tmap.get(maxKey);
					if (tlist.get(0).t == 1) {
						tlist.remove(0);
						if (tlist.size() == 0)
							tmap.remove(maxKey);
						else
							tmap.put(maxKey, tlist);
					} else {
						tmap.get(maxKey).get(0).t--;
					}
				}
				
/*				for (Entry<Integer, List<Trainer>> e : tmap.entrySet()) {
					System.out.print("Day " + e.getKey() + " -> ");
					for (Trainer tr : e.getValue()) {
						System.out.print(tr.s + ", ");
					}
					System.out.println();
				}*/
			}

			long tot_s = 0;
			for (Entry<Integer, List<Trainer>> e : tmap.entrySet()) {
				for (Trainer tr : e.getValue()) {
					tot_s += tr.t * tr.s;
				}
			}
			System.out.println(tot_s);
			
		}
		sc.close();
	}

}
