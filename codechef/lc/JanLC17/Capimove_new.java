package JanLC17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Capimove_new {
	public static void main(String[] args) {
		int t, n;

		Set<Node> set = new TreeSet<Node>((o1, o2) -> o2.pop > o1.pop ? 1 : -1);
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- != 0) {
			n = sc.nextInt();
			Node[] city = new Node[n];

			// insert population to set
			for (int i = 1; i <= n; i++) {
				city[i-1] = new Node(sc.nextLong(),i);
				set.add(city[i-1]);
				Set<Integer> s = new HashSet<Integer>();
				s.add(i);
				map.put(i, s);
			}
		
			Set<Integer> sorted = new LinkedHashSet<Integer>();
			for (Node node : set) { 
				sorted.add(node.n);
			}	

			// map edges between cities
			for (int i = 1; i < n; i++) {
				int v = sc.nextInt();
				int u = sc.nextInt();			
				map.get(v).add(u);
				map.get(u).add(v);	
			}
			
			
			
			for (int i = 1; i <= n; i++) {
				System.out.println("i -> "+map.get(i));
				sorted.removeAll(map.get(i));
				System.out.println(sorted.iterator().next());
				sorted.addAll(map.get(i));
			}
			
		}
		sc.close();
	}
}

class Node {
	Long pop;
	int n;
	int rank;
	Node(Long pop, int n) {
		this.pop = pop;
		this.n = n;
	}
}