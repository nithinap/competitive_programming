package lc.aug18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Problem implements Comparable<Problem> {
	int id;
	SubProblem[] sp;
	int rank;

	Problem(int id, SubProblem[] sp) {
		this.id = id;
		this.sp = sp;

		int diff = 0;
		for (int i = 0; i < sp.length-1; i++) {
			if (sp[i].ns > sp[i + 1].ns)
				diff++;
		}
		this.rank = diff;
	}

	@Override
	public int compareTo(Problem o) {
		int res = this.rank - o.rank;
		if (res == 0)
			return this.id - o.id;
		else
			return res;
	}

	@Override
	public String toString() {
		return "Prob [id=" + id + ", sp=" + Arrays.toString(sp) + ", rank=" + rank + "]";
	}
}

class SubProblem implements Comparable<SubProblem> {
	int score;
	int ns;

	public SubProblem(int score, int ns) {
		super();
		this.score = score;
		this.ns = ns;
	}

	@Override
	public int compareTo(SubProblem o) {
		return this.score - o.score;
	}

	@Override
	public String toString() {
		return "SP [score=" + score + ", ns=" + ns + "]\n";
	}
}

public class ProblemSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int p, s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ps = br.readLine().split(" ");
		p = Integer.parseInt(ps[0]);
		s = Integer.parseInt(ps[1]);
		Problem[] prob = new Problem[p];
		int k = 0;
		while (p-- > 0) {
			String[] spar = br.readLine().split(" ");
			String[] nsar = br.readLine().split(" ");
			SubProblem[] sp = new SubProblem[spar.length];
			for (int i = 0; i < spar.length; i++) {
				sp[i] = new SubProblem(Integer.parseInt(spar[i]), Integer.parseInt(nsar[i]));
			}
			Arrays.sort(sp);
			prob[k++] = new Problem(k - 1, sp);
		}
		Arrays.sort(prob);
		System.out.println(Arrays.toString(prob));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < k; i++) {
			sb.append((prob[i].id + 1) + "\n");
		}
		System.out.println(sb.toString());
	}
}
