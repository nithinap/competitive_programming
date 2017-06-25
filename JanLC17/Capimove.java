package JanLC17;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class City {
	long population;
	int index;
	int rank;

	City(long p, int index) {
		this.population = p;
		this.index = index;
	}

	City(City city) {
		this.population = city.population;
		this.index = city.index;
	}

}

public class Capimove {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t, n;
		Map<Integer, String> teleportmap = new HashMap<Integer, String>();
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		while (t-- != 0) {
			// n = Integer.parseInt(br.readLine());
			n = sc.nextInt();
			City[] input = new City[n];
			City[] sorted = new City[n];

			// Read population of cities
			for (int i = 1; i <= n; i++) {
				input[i - 1] = new City(sc.nextLong(), i);
				// sorted[i - 1] = new City(input[i - 1]);
				sorted[i - 1] = input[i - 1];
			}

			// this is the old school clumsy :p way to custom sort
			/*
			 * Arrays.sort(sorted, new Comparator<City>() {
			 * 
			 * @Override public int compare(City c1, City c2) { // -1 -less
			 * than, 1 - greater than, 0 - equal, all inversed for descending
			 * return (c2.population > c1.population) ? 1 : -1; }});
			 */

			// this is the new cool for custom sort, called lambda exp :P
			Arrays.sort(sorted, (City o1, City o2) -> (o2.population > o1.population ? 1 : -1));
			for (int i = 1; i <= n; i++) {
				sorted[i - 1].rank = i;
			}

			Map<Integer, Integer> sortmap = new HashMap<Integer, Integer>();
			for (int i = 1; i <= n; i++) {
				sortmap.put(input[i - 1].index, input[i - 1].rank);
				//System.out.println("inp "+input[i-1].index+" -> "+sortmap.get(input[i-1].index));
			}

			/*
			 * for (int i = 1; i <= n; i++) { System.out.println("i :" + i +
			 * "\n==========="); System.out.println("index : " + input[i -
			 * 1].index + "; pop: " + input[i - 1].population + "; rank: " +
			 * input[i - 1].rank); }
			 */
			// Read teleport edges
			for (int i = 1; i < n; i++) {
				int v = sc.nextInt();
				int u = sc.nextInt();

				// System.out.println("V : "+v+"; U : "+u);
				teleportmap.put(v, teleportmap.get(v) == null ? String.valueOf(u) : teleportmap.get(v) + "," + u);
				teleportmap.put(u, teleportmap.get(u) == null ? String.valueOf(v) : teleportmap.get(u) + "," + v);
			}
			sc.close();

			boolean[] infected = new boolean[n];
			int cap_index = 1;
			for (int i = 1; i <= n; i++) {
				//System.out.println("for i :"+i);
				cap_index = 1;
				Arrays.fill(infected, false);
				
				infected[sortmap.get(i)-1] = true;
				for (String edge : teleportmap.get(i).split(",")) {
					infected[sortmap.get(Integer.parseInt(edge))-1] = true;
					//System.out.println("Infected edge :"+sortmap.get(Integer.parseInt(edge)));
				}
				
				while (infected[cap_index - 1])
					cap_index++;
				System.out.print(input[cap_index-1].rank+" ");
			}
		}
	}
}