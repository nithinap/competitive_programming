package lc.apr18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class AveragePairs {
	public static void main(String[] args) {

		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

//			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			Set<Integer> sum_set = new HashSet<Integer>();
			Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

			for (int i = 0; i < n; i++) {
				sum_set.add(2 * a[i]);
				if (map.get(a[i]) != null) {
					Set<Integer> ind = map.get(a[i]);
					ind.add(i);
					map.put(a[i], ind);
				} else {
					Set<Integer> ind = new HashSet<>();
					ind.add(i);
					map.put(a[i], ind);
				}

			}

//			System.out.println(map);
			long pairs = 0;
			
			for (Integer sum : sum_set) {
//				Map<Integer, Set<Integer>> tmap = ((Map<Integer, Set<Integer>>) map).clone(); // new HashMap<Integer, Set<Integer>>(map);
//				System.out.println("For " + sum);
				Map<Integer, Set<Integer>> tmap = new HashMap<Integer, Set<Integer>>();
				tmap.putAll(map);
				
				for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
					int temp = sum - entry.getKey();
					if (tmap.get(temp) != null) {
						int t_size = map.get(temp).size();
						if (temp * 2 == sum) {
							if (t_size > 1) {
								int size = map.get(temp).size();
								pairs += size * (size - 1) / 2;
								tmap.remove(temp);
							} 
						} else {
//							System.out.print("pair " + temp + ", " + entry.getKey() + " | ");
							pairs += (t_size * entry.getValue().size());
							tmap.remove(temp);
							tmap.remove(entry.getKey());
//							System.out.println("count: " + pairs);
						}
					}
				}

			}

			System.out.println(pairs);
		}

		sc.close();
	}
}
