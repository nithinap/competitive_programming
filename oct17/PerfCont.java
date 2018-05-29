package lc.oct17;

import java.util.Scanner;

public class PerfCont {

	public static void main(String[] args) {
		int t, n;
		long p, solved;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t-- > 0) {
			n = sc.nextInt();
			p = sc.nextLong();
			
			int hard = (int) (p/10);
			int cakewalk = (int) (p/2);
			long no_easy = 0, no_hard = 0;
			
			for (int i=0; i<n; i++) {
				solved = sc.nextLong();
				if(solved >= cakewalk)
					no_easy++;
				else if(solved <= hard)
					no_hard++;
			}
			if(no_easy == 1 && no_hard == 2)
				System.out.println("yes");
			else
				System.out.println("no");
		}
		sc.close();
 	}

}
