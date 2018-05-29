package hackerearth.hiringchallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Pair<L, R> {

	private final L left;
	private final R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		return left.hashCode() ^ right.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair))
			return false;
		Pair pairo = (Pair) o;
		return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
	}

	@Override
	public String toString() {
		return "Pair [left=" + left + ", right=" + right + "]";
	}
}

class moComp implements Comparator<Pair<Pair<Integer, Integer>, Integer>> {

	private static int BLOCK_SIZE;

	moComp(int bSize) {
		BLOCK_SIZE = bSize;
	}

	@Override
	public int compare(Pair<Pair<Integer, Integer>, Integer> o1, Pair<Pair<Integer, Integer>, Integer> o2) {
		// TODO Auto-generated method stub
		int block_o1 = o1.getLeft().getLeft() / BLOCK_SIZE;
		int block_o2 = o2.getLeft().getLeft() / BLOCK_SIZE;

		if (block_o1 != block_o2)
			return block_o1 - block_o2;

		return o1.getLeft().getRight() - o2.getLeft().getRight();
	}

}

public class MosAlgo {
	private static int BLOCK_SIZE;
	private static long currentAns;
//	private static int[] freq = new int[1000000000];
	static Map<Integer, Integer> fmap = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		int n, q;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		BLOCK_SIZE = (int) Math.sqrt(n);

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			fmap.put(a[i], 0);
		}

		q = sc.nextInt();
		Pair<Pair<Integer, Integer>, Integer>[] pair = new Pair[q];

		for (int i = 0; i < q; i++) {
			pair[i] = new Pair(new Pair<Integer, Integer>(sc.nextInt()-1, sc.nextInt()-1), i);
		}

		Arrays.sort(pair, new moComp(BLOCK_SIZE));

		long[] ans = new long[q];
		// System.out.println(Arrays.toString(pair));
		int mo_left = 0, mo_right = -1;
		for (int i = 0; i < q; i++) {
			int l = pair[i].getLeft().getLeft();
			int r = pair[i].getLeft().getRight();

			while (mo_right < r) {
				mo_right++;
				add(a[mo_right]);
			}

			while (mo_left < l) {
				remove(a[mo_left]);
				mo_left++;
			}

			while (mo_right > r) {
				remove(a[mo_right]);
				mo_right--;
			}

			while (mo_left > l) {
				mo_left--;
				add(a[mo_left]);
			}

			ans[pair[i].getRight()] = currentAns;
		}
		
		for (int i=0; i<q; i++) {
			System.out.println(ans[i]);
		}

		sc.close();
	}

	private static void remove(int num) {
		if (fmap.get(num) % 2 == 1) {
			currentAns -= fmap.get(num) * num;
		}
		fmap.put(num, fmap.get(num)-1);
		if (fmap.get(num) % 2 == 1) {
			currentAns += fmap.get(num) * num;
		}
	}

	private static void add(int num) {
		if (fmap.get(num) % 2 == 1) {
			currentAns -= fmap.get(num) * num;
		}
		fmap.put(num, fmap.get(num)+1);
		if (fmap.get(num) % 2 == 1) {
			currentAns += fmap.get(num) * num;
		}
	}
}
